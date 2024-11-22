package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Models.Etudiant;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import EtudiantDaoImp.EtudiantDaoimp;

public class ShowEtudiant {
	
	@FXML
    private ImageView backgroundImage;

	
    @FXML
    private TableView<Etudiant> clientTable;

    @FXML
    private TableColumn<Etudiant, String> nomColumn;

    @FXML
    private TableColumn<Etudiant, String> prenomColumn;

    @FXML
    private TableColumn<Etudiant, String> cneColumn;

    @FXML
    private TableColumn<Etudiant, String> emailColumn;

    private ObservableList<Etudiant> clientList = FXCollections.observableArrayList();

    public void initialize() {
    	
        Image backgroundimg = new Image("/background.png");
    	nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cneColumn.setCellValueFactory(new PropertyValueFactory<>("cne"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadBackgroundImage();

        loadClientData();
    }

    
    private void loadBackgroundImage() {
        // Set the image in the ImageView from resources
        try {
            Image image = new Image(getClass().getResourceAsStream("/background.png"));
            backgroundImage.setImage(image);
        } catch (Exception e) {
            System.err.println("Background image could not be loaded: " + e.getMessage());
        }
    }
    
    private void loadClientData() {
        EtudiantDaoimp dao = new EtudiantDaoimp();
        clientList.setAll(dao.SelectAll());
        
        clientTable.setItems(clientList);
    }
}
