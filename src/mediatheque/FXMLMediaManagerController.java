/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author antho
 */
public class FXMLMediaManagerController extends ControlledScreen implements Initializable {

    @FXML
    private Label tempUserLabel;
    @FXML
    private Label tempMediasLabel;
    @FXML
    private ImageView iv_home;
    @FXML
    private TextField tf_search;
    @FXML
    private TableView<Media> tableMedias;
    @FXML
    private TableColumn<Media, String> typeCol;
    @FXML
    private TableColumn<Media, String> titleCol;
    @FXML
    private TableColumn<Media, String> authorCol;
    @FXML
    private TableColumn<Media, Date> yearCol;
    @FXML
    private TableColumn<Media, Integer> nbAvailableCol;
    @FXML
    private Button btn;
    @FXML
    private ImageView profilPicture;
    @FXML
    private Label l_type;
    @FXML
    private Label l_title;
    @FXML
    private Label l_author;
    @FXML
    private Label l_date;
    @FXML
    private TextArea ta_infos;
    @FXML
    private TableView<BorrowingCard> tableUserLoan;
    @FXML
    private TableColumn<BorrowingCard, String> clientCol;
    @FXML
    private TableColumn<BorrowingCard, String> renduCol;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        nbAvailableCol.setCellValueFactory(new PropertyValueFactory<>("nbDispo"));
        profilPicture.setImage(new Image("file:img/audio.png"));
        iv_home.setImage(new Image("file:img/home.png"));
        
        renduCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLimitDate().toString()));
        clientCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClient().getFirstName()+" "+cellData.getValue().getClient().getLastName()));
    }    

    @FXML
    protected void goToScreenHome(ActionEvent event){
       sm.setScreen(App.screenHomeID);
       sm.getController(App.screenHomeID).updateDatas();
    }

    @FXML
    private void handleResearchAction(KeyEvent event){
        String str = tf_search.getText();
        ObservableList<Media> tempList = FXCollections.observableArrayList();
        
        
        //Load if function of str
        if(!str.isEmpty()){
            tableMedias.setItems(mediatheque.getMediasList());
            for(int i=0; i<tableMedias.getItems().size(); i++){
                if(tableMedias.getItems().get(i).getTitle().toLowerCase().startsWith(str.toLowerCase()) || tableMedias.getItems().get(i).getAuthor().toLowerCase().startsWith(str.toLowerCase())){
                    tempList.add(tableMedias.getItems().get(i));
                }
            }
            tableMedias.setItems(tempList);
        } else{
            tableMedias.setItems(mediatheque.getMediasList());
        }
        
        //System.out.println(str);
    }

    @FXML
    private void handleAddtoCartAction(ActionEvent event) {
        Media m = tableMedias.getSelectionModel().getSelectedItem();
        if(m == null || m.getNbDispo() == 0){
            messageLabel.setText("Produit non disponible");
        }else{
            messageLabel.setText("");
            mediatheque.getTempCart().getMedias().add(m);
            tempUserLabel.setText(mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName());
            tempMediasLabel.setText(mediatheque.getTempCart().getMedias().size()+"");
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


    @FXML
    private void handleEditMediaAction(ActionEvent event) {
        mediatheque.getTempEdit().setM(tableMedias.getSelectionModel().getSelectedItem());
        if(mediatheque.getTempEdit().getM() != null){
            try {
                Stage stage;
                stage = new Stage();
                //stage.setScene(new Scene(root));
                stage.setTitle("Edit Media");
                stage.getIcons().add(new Image("file:img/icon.png"));
                stage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLEditMedia.fxml"));
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

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        Media m = tableMedias.getSelectionModel().getSelectedItem();
        mediatheque.getMediasList().remove(m);
    }

    @Override
    public void updateAfterLoadingScreen() {
        tableMedias.setItems(mediatheque.getMediasList());
        tableMedias.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
            if (tableMedias.getSelectionModel().getSelectedItem() != null) {
                l_title.setText(tableMedias.getSelectionModel().getSelectedItem().getTitle());
                l_author.setText(tableMedias.getSelectionModel().getSelectedItem().getAuthor());
                l_type.setText(tableMedias.getSelectionModel().getSelectedItem().getType());
                l_date.setText(tableMedias.getSelectionModel().getSelectedItem().getYear().toString());
                ta_infos.setText(tableMedias.getSelectionModel().getSelectedItem().toString());
                profilPicture.setImage(new Image("file:img/"+tableMedias.getSelectionModel().getSelectedItem().getType().toLowerCase()+".png"));
                ObservableList<BorrowingCard> tempList = FXCollections.observableArrayList();
                for(BorrowingCard bc : mediatheque.getLoansList()){
                    if(bc.getMedia() == tableMedias.getSelectionModel().getSelectedItem()){
                        tempList.add(bc);
                    }
                }
                tableUserLoan.setItems(tempList);
            }
        });
    }

    @Override
    public void updateDatas() {
        tableMedias.getColumns().get(0).setVisible(false);
        tableMedias.getColumns().get(0).setVisible(true);
        tempUserLabel.setText(mediatheque.getTempCart().getClient().getFirstName()+" "+mediatheque.getTempCart().getClient().getLastName());
        tempMediasLabel.setText(mediatheque.getTempCart().getMedias().size()+"");
    }
    
}
