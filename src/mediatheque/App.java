package mediatheque;

import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author antho
 */
public class App extends Application {
    
    public static String screenHomeID = "Home";
    public static String screenHomeFile = "FXMLHome.fxml";
    public static String screenUserManagerID = "UserManager";
    public static String screenUserManagerFile = "FXMLUserManager.fxml";
    public static String screenMediaManagerID = "MediaManager";
    public static String screenMediaManagerFile = "FXMLMediaManager.fxml";
    public static String screenOutStandingLoanID = "OutStandingLoan";
    public static String screenOutStandingLoanFile = "FXMLOutStandingLoan.fxml";
    public static String screen4ID = "NewLoan";
    public static String screen4File = "FXMLNewLoan.fxml";
    
    
    @Override
    public void start(Stage stage) throws Exception {
        ScreensManager mainContainer = new ScreensManager();
        Mediatheque m = new Mediatheque("Mediatheque");
        
        
        m.saveManager.load();
       
        
        mainContainer.loadScreen(App.screenHomeID, App.screenHomeFile, m);
        mainContainer.loadScreen(App.screenUserManagerID, App.screenUserManagerFile, m);
        mainContainer.loadScreen(App.screenMediaManagerID, App.screenMediaManagerFile, m);
        mainContainer.loadScreen(App.screenOutStandingLoanID, App.screenOutStandingLoanFile, m);
        
        mainContainer.setScreen(App.screenHomeID);
        //saveManager.save();
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        stage.setTitle("Mediathèque");
        stage.getIcons().add(new Image("file:img/icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
