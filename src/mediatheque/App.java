package mediatheque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public static String screen2ID = "NewUser";
    public static String screen2File = "FXMLNewUser.fxml";
    public static String screen3ID = "OutStandingLoan";
    public static String screen3File = "FXMLOutStandingLoan.fxml";
    public static String screen4ID = "NewLoan";
    public static String screen4File = "FXMLNewLoan.fxml";
    
    
    @Override
    public void start(Stage stage) throws Exception {
        ScreensManager mainContainer = new ScreensManager();
        Mediatheque m = new Mediatheque("Mediatheque");
        
        m.clientsList.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        m.clientsList.add(new Client("Bernard", "KIKOU", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        m.clientsList.add(new Client("Benjamin", "KRAFFT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        m.clientsList.add(new Client("Jessica", "FAVIN", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        m.clientsList.add(new Client("Sofian", "DAHOU", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        m.clientsList.add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250)));
        
        m.clientsList.get(2).setImg("file:img/profil2.png");
        m.clientsList.get(4).setImg("file:img/profil2.png");
        m.clientsList.get(5).setImg("file:img/profil.png");
        
        mainContainer.loadScreen(App.screenHomeID, App.screenHomeFile, m);
        mainContainer.loadScreen(App.screenUserManagerID, App.screenUserManagerFile, m);
        mainContainer.loadScreen(App.screen2ID, App.screen2File, m);
        mainContainer.loadScreen(App.screen3ID, App.screen3File, m);
        
        mainContainer.setScreen(App.screenHomeID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
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
