
package mediatheque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private void handleNewUserAction(ActionEvent event){
        try {
            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLNewUser.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("My modal window");
            stage.initModality(Modality.APPLICATION_MODAL);
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
    }    

    
    
    @Override
    public void updateAfterLoadingScreen() {
        
    }
    
}
