package be.vives.robin.chat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
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
import com.google.gson.Gson;
import be.biosplanet.bioboost.mqtt.simple_mqtt_client.IMQTTMessageHandler;
import be.biosplanet.bioboost.mqtt.simple_mqtt_client.SimpleMQTTClient;


public class NewSceneController implements Initializable {

    private String name; // name word hier nog gezet omdat het anders niet kenbaar is in deze controller

    public NewSceneController(String name) {
      this.name = name;//hier komt de naam van de vorige controller toe
    }

    @FXML
    private TextField inhoudtekst; //id van het textveld is inhoudtekst

    @FXML
    private TextArea chatvenster; // het textarea noemt chatvenster
   
    @FXML
    private TextField subscribeTopic;
    

    
    
    
    @FXML
    private void handlechat(ActionEvent event) throws Exception {
        ChatMessage message = new ChatMessage(inhoudtekst.getText(), this.name );//dit deel is om het ingetypte te versturen via MQTT
        
        Gson gson = new Gson();
        String json = gson.toJson(message);

        System.out.println(json);

        SimpleMQTTClient client = new SimpleMQTTClient();
        client.publish("test/oop2/chat/" + subscribeTopic.getText(), json);
        
        
    }

    @FXML
    private void subHandler(ActionEvent event) {
      
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SimpleMQTTClient client = new SimpleMQTTClient();//dit deel dient om berichten te ontvangen
        
        client.subscribe("test/oop2/chat/chat1", new IMQTTMessageHandler(){
            @Override
            public void messageArrived(String topic, String message) {
                Gson gson = new Gson();
                Message typeChecker = gson.fromJson(message, Message.class);
                System.out.println(typeChecker);
        
                
                if (typeChecker.getType().equals("chat_message")) {
                  //dit deel is enkel voor het type chat_message
                  ChatMessage reply = gson.fromJson(message, ChatMessage.class);
                  
                  chatvenster.appendText(reply.toString() + "\n");//hier word de binnengehaalde tekst gedisplayd, \n staat voor een nieuwe lijn
                  System.out.println(reply);
                  
                }
                
              System.out.println(message);
              }
          });
        
        
        
    }    
}