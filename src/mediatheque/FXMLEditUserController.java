/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author antho
 */
public class FXMLEditUserController extends ControlledScreen implements Initializable {

    @FXML
    private TextField tf_lastName;
    @FXML
    private TextField tf_firstName;
    @FXML
    private TextField tf_number;
    @FXML
    private TextField tf_street;
    @FXML
    private TextField tf_city;
    @FXML
    private TextField tf_zipcode;
    @FXML
    private TextField tf_country;

    @FXML
    private ChoiceBox<String> cb_sex;
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
        
        cb_sex.setItems(FXCollections.observableArrayList("Femme", "Homme"));
    }    


    @FXML
    private void handleSaveAction(ActionEvent event) {
        //int number, String street, String country, String city,int zipcode
        if(!(tf_firstName.getText().isEmpty()) && !(tf_lastName.getText().isEmpty()) && !(tf_number.getText().isEmpty())  && !(tf_street.getText().isEmpty()) && !(tf_country.getText().isEmpty()) && !(tf_city.getText().isEmpty()) && !(tf_zipcode.getText().isEmpty())&& !(cb_sex.getSelectionModel().getSelectedItem().isEmpty())){                     
            mediatheque.getTempEdit().getC().setFirstName(tf_firstName.getText());
            mediatheque.getTempEdit().getC().setLastName(tf_lastName.getText());
            if(cb_sex.getSelectionModel().getSelectedItem().equals("Femme")){
                mediatheque.getTempEdit().getC().setImg("file:img/girl.png");
            }else{
                mediatheque.getTempEdit().getC().setImg("file:img/profil2.png");
            }
            
            
            mediatheque.getTempEdit().getC().setAdress(new Adress(Integer.parseInt(tf_number.getText()), tf_street.getText(), tf_country.getText(), tf_city.getText(), Integer.parseInt(tf_zipcode.getText())));
            sm.getController(App.screenUserManagerID).updateDatas();
            mediatheque.saveManager.save();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }        
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void updateAfterLoadingScreen() {
        Client c = mediatheque.getTempEdit().getC();
        tf_lastName.setText(c.getLastName());
        tf_firstName.setText(c.getFirstName());
        tf_number.setText(c.getAdress().getNumber()+"");
        tf_street.setText(c.getAdress().getStreet());
        tf_city.setText(c.getAdress().getCity());
        tf_zipcode.setText(c.getAdress().getZipcode()+"");
        tf_country.setText(c.getAdress().getCountry());
    }

    @Override
    public void updateDatas() {
        
    }
    
}
