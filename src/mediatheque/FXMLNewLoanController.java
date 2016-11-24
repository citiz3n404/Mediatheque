/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FXMLNewLoanController extends ControlledScreen implements Initializable {
    
    @FXML
    private Label userLabel;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TableView<Media> tableCart;
    @FXML
    private TableColumn<Media, String> typeCol;
    @FXML
    private TableColumn<Media, String> titleCol;
    @FXML
    private TableColumn<Media, String> authorCol;
    @FXML
    private TableColumn<Media, Date> yearCol;
    @FXML
    private TableColumn<Media, Boolean> loanableCol;
    @FXML
    private TableColumn<Media, Boolean> availableCol;
    @FXML
    private TableColumn<Media, Integer> nbdispoCol;
    @FXML
    private Label pricelLabel;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        loanableCol.setCellValueFactory(new PropertyValueFactory<>("loanable"));
        availableCol.setCellValueFactory(new PropertyValueFactory<>("available"));
        nbdispoCol.setCellValueFactory(new PropertyValueFactory<>("nbDispo"));
        datepicker.setValue(LocalDate.now());
    }    

    @Override
    public void updateAfterLoadingScreen() {
        tableCart.setItems(mediatheque.getTempCart().getMedias());
        userLabel.setText("("+mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName()+")");
        double sum = 0;
        for(int i=0; i<mediatheque.getTempCart().getMedias().size(); i++){
            sum += mediatheque.getTempCart().getMedias().get(i).getCost();
        }
        pricelLabel.setText(""+sum);
    }

    @Override
    public void updateDatas() {
        
    }

    private boolean isValidCart(){
        Date date = new Date(datepicker.getValue().toEpochDay());
        if(date.toString().isEmpty()){
            return false;
        }
        if(mediatheque.getTempCart().getMedias().size() == 0){
            return false;
        }
        for(int i=0; i<mediatheque.getTempCart().getMedias().size(); i++){
            if(!mediatheque.getTempCart().getMedias().get(i).isAvailable() || !mediatheque.getTempCart().getMedias().get(i).isLoanable()){
                return false;
            }
            if(mediatheque.getTempCart().getMedias().get(i).getNbDispo() <= 0){
                return false;
            }
        }
        return true;
    }
    
    @FXML
    private void handleValidateAction(ActionEvent event) {
        if(!isValidCart()){
            messageLabel.setText("Le panier est invalide, pas de stock ou pas empruntable, date");
        }else{
            double sum = 0;
            for(int i=0; i<mediatheque.getTempCart().getMedias().size(); i++){
                sum += mediatheque.getTempCart().getMedias().get(i).getCost();
            }
            for(Media m: mediatheque.getTempCart().getMedias()){
                mediatheque.getLoansList().add(new BorrowingCard(new Date(), new Date(), new Date(), false, sum, mediatheque.getTempCart().getClient(), m));
                mediatheque.getTempCart().getClient().setNbCurrentLoan(mediatheque.getTempCart().getClient().getNbCurrentLoan()+1);
                sm.getController(App.screenUserManagerID).updateDatas();
                
            }
            mediatheque.getTempCart().getMedias().clear();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) {
        Media m = tableCart.getSelectionModel().getSelectedItem();
        mediatheque.getTempCart().getMedias().remove(m);
        double sum = 0;
        for(int i=0; i<mediatheque.getTempCart().getMedias().size(); i++){
            sum += mediatheque.getTempCart().getMedias().get(i).getCost();
        }
        pricelLabel.setText(""+sum);
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        //AJOUTER la maj de la barre
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
