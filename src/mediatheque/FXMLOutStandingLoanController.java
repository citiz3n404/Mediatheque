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
 * FXML Controller class
 *
 * @author Benjamin
 */

public class FXMLOutStandingLoanController extends ControlledScreen implements Initializable {

    @FXML
    private Label tempUserLabel;
    
    @FXML
    private Label tempMediasLabel;
     
    @FXML
    private ImageView iv_home;
    
    @FXML
    private TableView<BorrowingCard> tableLoan;
    
    @FXML
    private TableColumn<BorrowingCard, String> clientCol;
    
    @FXML
    private TableColumn<BorrowingCard, String> mediaCol;

    @FXML
    private TableColumn<BorrowingCard, Date> reminderCol;

    @FXML
    private TableColumn<BorrowingCard, Boolean> overdatedCol;

    @FXML
    private TableColumn<BorrowingCard, Date> limitCol;
    
    @FXML
    private TableView<BorrowingCard> tableUserLoan;
    
    @FXML
    private TableColumn<BorrowingCard, String> titleCol;
    
    @FXML
    private TableColumn<BorrowingCard, String> renduCol;
    
    @FXML
    private TextField tf_search;
    
    @FXML
    private Label firstNameLabel;
    
    @FXML
    private Label lastNameLabel;
    
    @FXML
    private ImageView profilPicture;


    /**
     * Initializes the controller class.
     */
    
    
     @FXML
    private void handleResearchAction(KeyEvent event){
        String str = tf_search.getText();
        ObservableList<BorrowingCard> tempList = FXCollections.observableArrayList();
        
        
        //Load if function of str
        if(!str.isEmpty()){
            tableLoan.setItems(mediatheque.getLoansList());
            for(int i=0; i<tableLoan.getItems().size(); i++){
                if(tableLoan.getItems().get(i).getClient().getFirstName().toLowerCase().startsWith(str.toLowerCase()) || tableLoan.getItems().get(i).getMedia().getTitle().toLowerCase().startsWith(str.toLowerCase())){
                    tempList.add(tableLoan.getItems().get(i));
                }
            }
            tableLoan.setItems(tempList);
        } else{
            tableLoan.setItems(mediatheque.getLoansList());
        }
        
        //System.out.println(str);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iv_home.setImage(new Image("file:img/home.png"));
        
        clientCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClient().getFirstName()+" "+cellData.getValue().getClient().getLastName()));
        mediaCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMedia().getTitle()));
        reminderCol.setCellValueFactory(new PropertyValueFactory<>("reminderDate"));
        limitCol.setCellValueFactory(new PropertyValueFactory<>("limitDate"));
        overdatedCol.setCellValueFactory(new PropertyValueFactory<>("rendu"));
        titleCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMedia().getTitle()));
        renduCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLimitDate().toString()));
           
    }    
    
        @FXML
    private void handleCartAction(ActionEvent event){
        try {
            Stage stage;
            stage = new Stage();
            //stage.setScene(new Scene(root));
            stage.setTitle("Panier");
            stage.getIcons().add(new Image("file:img/icon.png"));
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
    
    
    
    @FXML
    protected void goToScreenHome(ActionEvent event){
       sm.setScreen(App.screenHomeID);
       sm.getController(App.screenHomeID).updateDatas();
    }

    @Override
    public void updateAfterLoadingScreen() {
        tableLoan.setItems(mediatheque.getLoansList());
        tableLoan.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
            if (tableLoan.getSelectionModel().getSelectedItem() != null) {
                firstNameLabel.setText(tableLoan.getSelectionModel().getSelectedItem().getClient().getFirstName());
                lastNameLabel.setText(tableLoan.getSelectionModel().getSelectedItem().getClient().getLastName());
                profilPicture.setImage(new Image("file:img/"+tableLoan.getSelectionModel().getSelectedItem().getMedia().getType().toLowerCase()+".png"));
                
                ObservableList<BorrowingCard> tempList = FXCollections.observableArrayList();
                for(BorrowingCard bc : mediatheque.getLoansList()){
                    if(bc.getClient() == tableLoan.getSelectionModel().getSelectedItem().getClient()){
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
        tableLoan.getColumns().get(0).setVisible(false);
        tableLoan.getColumns().get(0).setVisible(true);
        
    }

    @FXML
    private void handleRenduAction(ActionEvent event) {
        if(tableLoan.getSelectionModel().getSelectedItem() != null){
            tableLoan.getSelectionModel().getSelectedItem().setRendu(true);
            tableLoan.getSelectionModel().getSelectedItem().getMedia().setNbDispo(tableLoan.getSelectionModel().getSelectedItem().getMedia().getNbDispo()+1);
            sm.getController(App.screenHomeID).updateDatas();
            sm.getController(App.screenOutStandingLoanID).updateDatas();
            mediatheque.saveManager.save();
        }
    }
    
}
