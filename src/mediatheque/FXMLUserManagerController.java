package mediatheque;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private ImageView iv_home;
    @FXML
    private TableView<BorrowingCard> tableUserLoan;
    @FXML
    private TableColumn<BorrowingCard, String> titleUserLoanCol;
    @FXML
    private TableColumn<BorrowingCard, String> renduUserLoanCol;
    
    
    @FXML
    private void handleCartAction(ActionEvent event){
        try {
            Stage stage;
            stage = new Stage();
            //stage.setScene(new Scene(root));
            stage.setTitle("My modal window");
            stage.initModality(Modality.APPLICATION_MODAL);
            
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLNewLoan.fxml"));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController()); 
            myScreenControler.setDatas(mediatheque);
            myScreenControler.setScreenParent(sm);
            myScreenControler.updateAfterLoadingScreen();
            
            stage.setScene(new Scene(loadScreen));
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void handleButtonAction(ActionEvent event) {
        Client c =new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png");
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
        mediatheque.getTempCart().setClient(tableUsers.getSelectionModel().getSelectedItem());
        tempUserLabel.setText(mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName());
        tempMediasLabel.setText(mediatheque.getTempCart().getMedias().size()+"");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fisrtnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nbEmpruntCol.setCellValueFactory(new PropertyValueFactory<>("nbCurrentLoan"));
        nbLateCol.setCellValueFactory(new PropertyValueFactory<>("nbLoanDelayed"));
        profilPicture.setImage(new Image("file:img/profil2.png"));
        iv_home.setImage(new Image("file:img/home.png"));
        renduUserLoanCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLimitDate().toString()));
        titleUserLoanCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMedia().getTitle()));
        
    }    

    
    @FXML
    protected void goToScreenHome(ActionEvent event){
       sm.setScreen(App.screenHomeID);
       sm.getController(App.screenHomeID).updateDatas();
    }

    @Override
    public void updateAfterLoadingScreen() {       
        tableUsers.setItems(mediatheque.getClientsList());
        tableUsers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
            if (tableUsers.getSelectionModel().getSelectedItem() != null) {
                firstNameLabel.setText(tableUsers.getSelectionModel().getSelectedItem().getFirstName());
                lastNameLabel.setText(tableUsers.getSelectionModel().getSelectedItem().getLastName());
                adressTextArea.setText(tableUsers.getSelectionModel().getSelectedItem().getAdress().toString());
                profilPicture.setImage(new Image(tableUsers.getSelectionModel().getSelectedItem().getImg()));
                
                ObservableList<BorrowingCard> tempList = FXCollections.observableArrayList();
                for(BorrowingCard bc : mediatheque.getLoansList()){
                    if(bc.getClient() == tableUsers.getSelectionModel().getSelectedItem()){
                        tempList.add(bc);
                    }
                }
                tableUserLoan.setItems(tempList);
                
            }
        });
    }

    @Override
    public void updateDatas() {
        tempUserLabel.setText(mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName());
        tempMediasLabel.setText(mediatheque.getTempCart().getMedias().size()+"");
        tableUsers.getColumns().get(0).setVisible(false);
        tableUsers.getColumns().get(0).setVisible(true);
        tableUserLoan.getColumns().get(0).setVisible(false);
        tableUserLoan.getColumns().get(0).setVisible(true);
    }
    
    @FXML
    private void handleNewUserAction(ActionEvent event){
        try {
            Stage stage;
            stage = new Stage();
            //stage.setScene(new Scene(root));
            stage.setTitle("My modal window");
            stage.initModality(Modality.APPLICATION_MODAL);
            
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLNewUser.fxml"));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController()); 
            myScreenControler.setDatas(mediatheque);
            myScreenControler.setScreenParent(sm);
            myScreenControler.updateAfterLoadingScreen();
            
            stage.setScene(new Scene(loadScreen));
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
