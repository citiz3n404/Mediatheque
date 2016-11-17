package mediatheque;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author antho
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
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
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("You clicked me!");
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        label.setText("Aurevoir !");
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
        ObservableList<Client> clients = FXCollections.observableArrayList();
        clients.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        clients.add(new Client("Bernard", "KIKOU", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        clients.add(new Client("Benjamin", "KRAFFT", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        clients.add(new Client("Jessica", "FAVIN", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        clients.add(new Client("Sofian", "DAHOU", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        clients.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250), new Date(), new Date(), 0, 0, 0));
        return clients;
    }
    
}
