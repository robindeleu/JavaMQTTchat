package be.vives.robin.chat;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;


public class FXMLController implements Initializable {
    
    @FXML
    private TextField nickname; // nickname is het textveld
        
    @FXML
    private void handlelogin(ActionEvent event) throws Exception {
        
        String name = nickname.getText(); //dit is de koppeling tussen de knop en het tekstveld
        System.out.println(" je gebruikersnaam is: " + nickname.getText());// in console zie je wie er ingelogd is
       
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //dit deel zorgt voor het omswitchen van scenes
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));//deze zegt welke de volgende scene is

        NewSceneController controller = new NewSceneController(name);//niewe contoller aanroepen en hem "naam" megeven
        loader.setController(controller);//controller laden
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        stage.hide(); //dit deel zorgt voor het afsluiten van het loginscherm
        stage.setScene(newScene);
        stage.show();        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
}
