package mediatheque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FXMLOutStandingLoanController extends ControlledScreen implements Initializable {

    @FXML
    private ImageView iv_home;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iv_home.setImage(new Image("file:img/home.png"));
    }    
    
    @FXML
    protected void goToScreenHome(ActionEvent event){
       sm.setScreen(App.screenHomeID);
       sm.getController(App.screenHomeID).updateDatas();
    }

    @Override
    public void updateAfterLoadingScreen() {
        
    }

    @Override
    public void updateDatas() {
        
    }
    
}
