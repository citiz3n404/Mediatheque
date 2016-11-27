
package mediatheque;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author antho
 */
public class FXMLHomeController extends ControlledScreen implements Initializable {

    @FXML
    private Label tempUserLabel;
    @FXML
    private Label tempMediasLabel;
    
    @FXML
    private ImageView userIcon;
    
    @FXML
    private ImageView mediaIcon;
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
    private TableView<Media> tableCart;
    @FXML
    private TableColumn<Media, String> typeCol;
    @FXML
    private TableColumn<Media, String> titleCol;
    
    @FXML
    protected void goToScreenUserManager(ActionEvent event){
       sm.setScreen(App.screenUserManagerID);
       sm.getController(App.screenUserManagerID).updateDatas();
    }
    
    @FXML
    protected void goToScreenOutstandingLoad(ActionEvent event){
       sm.setScreen(App.screenOutStandingLoanID);
       sm.getController(App.screenOutStandingLoanID).updateDatas();
    }
    
    @FXML
    protected void goToScreenMedias(ActionEvent event){
       sm.setScreen(App.screenMediaManagerID);
       sm.getController(App.screenMediaManagerID).updateDatas();
    }
    
    @FXML
    private void handleNewUserAction(ActionEvent event){
        try {
            Stage stage;
            stage = new Stage();
            //stage.setScene(new Scene(root));
            stage.setTitle("New user");
            stage.getIcons().add(new Image("file:img/icon.png"));
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
    private void handleNewMediaAction(ActionEvent event){
        try {
            Stage stage;
            stage = new Stage();
            //stage.setScene(new Scene(root));
            stage.setTitle("New Media");
            stage.getIcons().add(new Image("file:img/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLNewMedia.fxml"));
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userIcon.setImage(new Image("file:img/person-flat.png"));
        mediaIcon.setImage(new Image("file:img/Cd-icon.png"));
        
        clientCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClient().getFirstName()+" "+cellData.getValue().getClient().getLastName()));
        mediaCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMedia().getTitle()));
        reminderCol.setCellValueFactory(new PropertyValueFactory<>("reminderDate"));
        limitCol.setCellValueFactory(new PropertyValueFactory<>("limitDate"));
        overdatedCol.setCellValueFactory(new PropertyValueFactory<>("rendu"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
    }    

    
    
    @Override
    public void updateAfterLoadingScreen() {
        tableLoan.setItems(mediatheque.getLoansList());
        tableCart.setItems(mediatheque.getTempCart().getMedias());
    }

    @Override
    public void updateDatas() {
        tempUserLabel.setText(mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName());
        tempMediasLabel.setText(mediatheque.getTempCart().getMedias().size()+"");
        tableLoan.getColumns().get(0).setVisible(false);
        tableLoan.getColumns().get(0).setVisible(true);
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        mediatheque.saveManager.save();
    }
    
}
