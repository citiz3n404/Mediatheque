package mediatheque;

import java.util.Date;
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
        
        m.getClientsList().add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("Bernard", "KIKOU", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("Benjamin", "KRAFFT", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("Jessica", "FAVIN", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("Sofian", "DAHOU", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        m.getClientsList().add(new Client("TEST", "HELLO", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png"));
        
        m.getMediasList().add(new Audio("Meteora", "LinkinPark", new Date(), true, true, 15, "RAP/ROCK"));
        m.getMediasList().add(new Audio("Symphone 7", "Beethoven", new Date(), true, true, 2, "CLASSIC"));
        m.getMediasList().add(new Livre("Improbable", "Adam Fawer", new Date(), true, true, 5, 30));
        m.getMediasList().add(new Video("Interstellar", "Christopher Nolan", new Date(), true, true, 3, "MIT Licence"));
        m.getMediasList().add(new Audio("Meteora", "LinkinPark", new Date(), true, true, 4, "RAP/ROCK"));
        m.getMediasList().add(new Audio("Meteora", "LinkinPark", new Date(), true, true, 8, "JAZZ"));
        m.getMediasList().add(new Video("V for Vendetta", "James McTeigue", new Date(), true, true, 15, "MIT Licence"));
        
        
        
        m.getClientsList().get(2).setImg("file:img/profil2.png");
        m.getClientsList().get(4).setImg("file:img/profil2.png");
        m.getClientsList().get(5).setImg("file:img/profil.png");
        
        mainContainer.loadScreen(App.screenHomeID, App.screenHomeFile, m);
        mainContainer.loadScreen(App.screenUserManagerID, App.screenUserManagerFile, m);
        mainContainer.loadScreen(App.screenMediaManagerID, App.screenMediaManagerFile, m);
        mainContainer.loadScreen(App.screenOutStandingLoanID, App.screenOutStandingLoanFile, m);
        
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
