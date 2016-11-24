/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;

import java.io.File;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FXMLNewMediaController extends ControlledScreen implements Initializable {

    @FXML
    private ChoiceBox cb_type;
    @FXML
    private TextField tf_title;
    @FXML
    private TextField tf_author;
    @FXML
    private TextArea tf_disclamer;
    @FXML
    private TextField tf_classification;
    @FXML
    private TextField tf_nbpage;
    @FXML
    private TextField tf_nbdispo;
    @FXML
    private DatePicker dp_date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_nbpage.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_nbpage.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        tf_nbdispo.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_nbdispo.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        cb_type.setItems(FXCollections.observableArrayList("BOOK", "AUDIO", "VIDEO"));
        cb_type.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable,
                                Object oldValue, Object newValue) -> {
                    
                    if ((String) newValue != null) {
                        switch ((String) newValue) {
                            case "BOOK":
                                tf_classification.setDisable(true);
                                tf_nbpage.setDisable(false);
                                tf_disclamer.setDisable(true);
                                break;
                            case "AUDIO":
                                tf_classification.setDisable(false);
                                tf_nbpage.setDisable(true);
                                tf_disclamer.setDisable(true);
                                break;
                            case "VIDEO":
                                tf_classification.setDisable(true);
                                tf_nbpage.setDisable(true);
                                tf_disclamer.setDisable(false);
                                break;
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

    @FXML
    private void handleValidateAction(ActionEvent event) {
        
        if(!tf_title.getText().isEmpty() && !tf_author.getText().isEmpty() && !tf_nbdispo.getText().isEmpty() && !((String)cb_type.getSelectionModel().getSelectedItem()).isEmpty() && !dp_date.getValue().toString().isEmpty()){
            String str = (String)cb_type.getSelectionModel().getSelectedItem();
            Date date = new Date(dp_date.getValue().toEpochDay());
            switch(str){
                case "AUDIO":
                    if(!tf_classification.getText().isEmpty()){
                        mediatheque.addMedia(new Audio(tf_title.getText(), tf_author.getText(), date, true, true, Integer.parseInt(tf_nbdispo.getText()),tf_classification.getText()));
                        ((Node)event.getSource()).getScene().getWindow().hide();
                    }
                    break;
                case "VIDEO":
                    if(!tf_disclamer.getText().isEmpty()){
                        mediatheque.addMedia(new Video(tf_title.getText(), tf_author.getText(), date, true, true, Integer.parseInt(tf_nbdispo.getText()),tf_disclamer.getText()));
                        ((Node)event.getSource()).getScene().getWindow().hide();
                    }
                    break;
                case "BOOK":
                    if(!tf_nbpage.getText().isEmpty()){
                        mediatheque.addMedia(new Livre(tf_title.getText(), tf_author.getText(), date, true, true, Integer.parseInt(tf_nbdispo.getText()), Integer.parseInt(tf_nbpage.getText())));
                        ((Node)event.getSource()).getScene().getWindow().hide();
                    }
                    break;
            }
        }
                
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
