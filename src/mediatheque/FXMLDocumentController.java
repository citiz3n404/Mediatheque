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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author antho
 */
public class FXMLDocumentController implements Initializable, ControlledScreen {
    
    private Mediatheque m;
    
    private ScreensManager sm;
    
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
    
    ObservableList<Client> clients = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        clients.add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fisrtnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nbEmpruntCol.setCellValueFactory(new PropertyValueFactory<>("nbLoanDone"));
        nbLateCol.setCellValueFactory(new PropertyValueFactory<>("nbLoanDelayed"));
        tableUsers.setItems(getClients());
    }    
    
    public ObservableList<Client> getClients(){
        //ICI on charge la base de données.
        
        clients.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        clients.add(new Client("Bernard", "KIKOU", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        clients.add(new Client("Benjamin", "KRAFFT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        clients.add(new Client("Jessica", "FAVIN", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        clients.add(new Client("Sofian", "DAHOU", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        clients.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        return clients;
    }

    @Override
    public void setScreenParent(ScreensManager screenPage) {
        this.sm = screenPage;
    }

    @Override
    public void setDatas(Object o) {
        m = (Mediatheque) o;
    }
    
    @FXML
    private void goToScreen2(ActionEvent event){
       sm.setScreen(App.screen2ID);
    }
    
}
