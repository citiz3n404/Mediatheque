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
    
    public static String screen1ID = "SCREEN1";
    public static String screen1File = "FXMLDocument.fxml";
    public static String screen2ID = "screen2";
    public static String screen2File = "FXMLDocument_1.fxml";
    public static String screen3ID = "screen3";
    public static String screen3File = "FXMLDocument_2.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        ScreensManager mainContainer = new ScreensManager();
        Mediatheque m = new Mediatheque("Mediatheque");
        
        mainContainer.loadScreen(App.screen1ID, App.screen1File, m);
        mainContainer.loadScreen(App.screen2ID, App.screen2File, m);
        mainContainer.loadScreen(App.screen3ID, App.screen3File, m);
        
        mainContainer.setScreen(App.screen1ID);
        
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
