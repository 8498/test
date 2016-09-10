package com.plox.esportsystem.controller.tables;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.plox.esportsystem.controller.ControllerPane;
import com.plox.esportsystem.model.entities.Office;
import com.plox.esportsystem.model.entities.OfficeManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class officesTablePaneController implements Initializable, ControllerPane {

	private final static officesTablePaneController INSTANCE = new officesTablePaneController();
	
	public static ControllerPane getInstance() {
		return INSTANCE;
	}

	private Pane newpane;
	
	@Override
	public void generatePane(Pane pane, String fxml, String style, int userID) {
		
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(fxml));
        fxmlloader.setController(this);
        
        try {
			newpane = (Pane) fxmlloader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        newpane.getStylesheets().add(style);
        
        newpane.getChildren().add(getTableView());
        newpane.getChildren().add(getAddButton());
        
        pane.getChildren().add(newpane);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("unchecked")
	private TableView<?> getTableView() {
		OfficeManager officeManager = new OfficeManager();
		
		TableView<Office> officesTable = new TableView<Office>();
		ObservableList<Office> offices = FXCollections.observableArrayList(officeManager.getAll());
		
		TableColumn<Office, String> idCol = new TableColumn<Office, String>("Id");
	    idCol.setCellValueFactory(
	            new PropertyValueFactory<Office, String>("id")
	    );
	    TableColumn<Office, String> nameCol = new TableColumn<Office, String>("Nazwa");
	    nameCol.setCellValueFactory(
	            new PropertyValueFactory<Office, String>("name")
	    );
	    
	    officesTable.getColumns().addAll(idCol, nameCol);

	    officesTable.setItems(offices);
	    
	    officesTable.setPrefSize(580, 380);
		return officesTable;
	}
	
	public Button getAddButton()
	{
		Button addFormButton = new Button("Dodaj");
		
		addFormButton.autosize();
		addFormButton.setTranslateY(400);
        addFormButton.setOnMouseClicked((e) -> {
        	
        });
        
		return addFormButton;
	}
}