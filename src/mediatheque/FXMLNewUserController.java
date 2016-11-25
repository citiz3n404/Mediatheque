/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FXMLNewUserController extends ControlledScreen implements Initializable {
    
    @FXML
    private TextField tf_firstName;
    
    @FXML
    private TextField tf_lastName;
    
    @FXML
    private TextField tf_street;
    
    @FXML
    private TextField tf_zipcode;
    
    @FXML
    private TextField tf_city;
    
    @FXML
    private TextField tf_country;
    
    @FXML
    private TextField tf_number;
    
    @FXML
    private ChoiceBox<String> cb_sex;
    
    @FXML
    private void handleSaveAction(ActionEvent event){
        if(!(tf_firstName.getText().isEmpty()) && !(tf_lastName.getText().isEmpty()) && !(tf_number.getText().isEmpty())  && !(tf_street.getText().isEmpty()) && !(tf_country.getText().isEmpty()) && !(tf_city.getText().isEmpty()) && !(tf_zipcode.getText().isEmpty())&& !(cb_sex.getSelectionModel().getSelectedItem().isEmpty())){
                       
            if(cb_sex.getSelectionModel().getSelectedItem().equals("Femme")){
                mediatheque.addCLient(new Client(tf_firstName.getText(), tf_lastName.getText(), new Adress(Integer.parseInt(tf_number.getText()), tf_street.getText(), tf_country.getText(),tf_city.getText(), Integer.parseInt(tf_zipcode.getText())), "file:img/girl.png"));
            }else{
                mediatheque.addCLient(new Client(tf_firstName.getText(), tf_lastName.getText(), new Adress(Integer.parseInt(tf_number.getText()), tf_street.getText(), tf_country.getText(),tf_city.getText(), Integer.parseInt(tf_zipcode.getText())), "file:img/profil2.png"));
            }
            
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
        
    }
    
    
    
    @FXML
    private void handleCancelAction(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_number.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_number.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        tf_zipcode.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_zipcode.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    }    

    @Override
    public void updateAfterLoadingScreen() {
        cb_sex.setItems(FXCollections.observableArrayList("Femme", "Homme"));
    }

    @Override
    public void updateDatas() {
        
    }
    
}
