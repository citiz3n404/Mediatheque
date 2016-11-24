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
    private ChoiceBox cb_type;
    
    private String imgPath;
    
    @FXML
    private void handleSaveAction(ActionEvent event){
        if(!(tf_firstName.getText().isEmpty()) && !(tf_lastName.getText().isEmpty()) && !(tf_number.getText().isEmpty())  && !(tf_street.getText().isEmpty()) && !(tf_country.getText().isEmpty()) && !(tf_city.getText().isEmpty()) && !(tf_zipcode.getText().isEmpty())&& !(imgPath.isEmpty())){
                       
            
            mediatheque.addCLient(new Client(tf_firstName.getText(), tf_lastName.getText(), new Adress(Integer.parseInt(tf_number.getText()), tf_street.getText(), tf_country.getText(),tf_city.getText(), Integer.parseInt(tf_zipcode.getText())), "file:img/profil2.png"));
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
        
    }
    
    
    
    @FXML
    private void handleCancelAction(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    @FXML
    private void handleLoadImgAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Img", "*.jpg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imgPath = selectedFile.getPath();
            System.out.println(selectedFile.getName());
        }
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
        
    }

    @Override
    public void updateDatas() {
        
    }
    
}
