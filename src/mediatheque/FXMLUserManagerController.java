package mediatheque;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author antho
 */
public class FXMLUserManagerController extends ControlledScreen implements Initializable {

    
    @FXML
    private Button btn;
    
    @FXML
    private TableView<Client> tableUsers;
    
    @FXML 
    private TableColumn<Client, String> fisrtnameCol;
    
    @FXML 
    private TableColumn<Client, String> lastnameCol;
    
    @FXML 
    private TableColumn<Client, Integer> nbEmpruntCol;
    
    @FXML 
    private TableColumn<Client, Integer> nbLateCol;
    
    @FXML
    private Label firstNameLabel;
    
    @FXML
    private Label lastNameLabel;
    
    @FXML
    private TextArea adressTextArea;
    
    @FXML
    private ImageView profilPicture;
    
    @FXML
    private Label tempUserLabel;
    
    @FXML
    private Label tempMediasLabel;
    
    @FXML
    private TextField tf_search;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Client c =new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250));
        mediatheque.getClientsList().add(c);
    }
    
    @FXML
    private void handleRemoveAction(ActionEvent event) {
        Client c = tableUsers.getSelectionModel().getSelectedItem();
        mediatheque.getClientsList().remove(c);
    }
    
    @FXML
    private void handleResearchAction(KeyEvent event){
        String str = tf_search.getText();
        ObservableList<Client> tempList = FXCollections.observableArrayList();
        
        
        //Load if function of str
        if(!str.isEmpty()){
            tableUsers.setItems(mediatheque.getClientsList());
            for(int i=0; i<tableUsers.getItems().size(); i++){
                if(tableUsers.getItems().get(i).getFirstName().toLowerCase().startsWith(str.toLowerCase()) || tableUsers.getItems().get(i).getLastName().toLowerCase().startsWith(str.toLowerCase())){
                    tempList.add(tableUsers.getItems().get(i));
                }
            }
            tableUsers.setItems(tempList);
        } else{
            tableUsers.setItems(mediatheque.getClientsList());
        }
        
        //System.out.println(str);
    }
    
    @FXML
    private void handleSelectAction(ActionEvent event){
        mediatheque.tempCart.setClient(tableUsers.getSelectionModel().getSelectedItem());
        tempUserLabel.setText(mediatheque.tempCart.getClient().getFirstName()+" "+mediatheque.tempCart.getClient().getLastName());
        tempMediasLabel.setText(mediatheque.tempCart.getMedias().size()+"");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fisrtnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nbEmpruntCol.setCellValueFactory(new PropertyValueFactory<>("nbLoanDone"));
        nbLateCol.setCellValueFactory(new PropertyValueFactory<>("nbLoanDelayed"));
        profilPicture.setImage(new Image("file:img/profil2.png"));
    }    

    @FXML
    private void goToScreen2(ActionEvent event){
       sm.setScreen(App.screen2ID);
    }

    @Override
    public void updateAfterLoadingScreen() {
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        mediatheque.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        
        tableUsers.setItems(mediatheque.getClientsList());
        tableUsers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
            if (tableUsers.getSelectionModel().getSelectedItem() != null) {
                firstNameLabel.setText(tableUsers.getSelectionModel().getSelectedItem().getFirstName());
                lastNameLabel.setText(tableUsers.getSelectionModel().getSelectedItem().getLastName());
                adressTextArea.setText(tableUsers.getSelectionModel().getSelectedItem().getAdress().toString());
                profilPicture.setImage(new Image(tableUsers.getSelectionModel().getSelectedItem().getImg()));
            }
        });
    }
    
}
