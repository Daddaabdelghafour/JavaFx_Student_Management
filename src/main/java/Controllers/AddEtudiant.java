package Controllers;

import EtudiantDaoImp.EtudiantDaoimp;
import Models.Etudiant;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddEtudiant {

	@FXML
	private ImageView backgroundImage;
	
    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    private TextField cneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button ajouterButton;

    @FXML
    private void initialize() {
        ajouterButton.setOnAction(e -> ajouterClient());
        loadBackgroundImage();
    }

    
    private void loadBackgroundImage() {
        try {
            Image image = new Image(getClass().getResourceAsStream("/background.png"));
            backgroundImage.setImage(image);
        } catch (Exception e) {
            System.err.println("Background image could not be loaded: " + e.getMessage());
        }
    }
    
    
    private void ajouterClient() {
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String cne = cneTextField.getText();
        String email = emailTextField.getText();

        Etudiant c = new Etudiant(nom,prenom,cne,email);
        EtudiantDaoimp e = new EtudiantDaoimp();
        e.saveStudent(c);
        System.out.println("Client Added: " + nom + ", " + prenom + ", " + cne + ", " + email);
    }
}
