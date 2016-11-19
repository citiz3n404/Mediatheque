/* 
 * Creation : 19 nov. 2016
 */
package mediatheque;

import java.util.HashMap;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;



/**
 * @date    19 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class ScreensManager extends StackPane{
    
    private HashMap<String, Node> screens = new HashMap<>();
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public ScreensManager(){
        super();
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    //Add the screen to the collection
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    //Returns the Node with the appropriate name
    public Node getScreen(String name) {
        return screens.get(name);
    }

    //Loads the fxml file, add the screen to the screens collection and
    //finally injects the screenPane to the controller.
    public boolean loadScreen(String name, String resource, Object datas) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController()); // PAs de controller, donc il faut les faire
            myScreenControler.setScreenParent(this);
            myScreenControler.setDatas(datas);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage()+" Le screen ne s'est pas chargé");
            return false;
        }
    }

    //This method tries to displayed the screen with a predefined name.
    //First it makes sure the screen has been already loaded.  Then if there is more than
    //one screen the new screen is been added second, and then the current screen is removed.
    // If there isn't any screen being displayed, the new screen is just added to the root.
    public boolean setScreen(String name) {       
        if (screens.get(name) != null) {   //screen loaded
            if (!getChildren().isEmpty()) {    //if there is more than one screen
                getChildren().remove(0);                    //remove the displayed screen
                getChildren().add(0, screens.get(name));     //add the screen
                        
            } else {
                //setOpacity(0.0);
                getChildren().add(screens.get(name));       //no one else been displayed, then just show
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }


        /*Node screenToRemove;
         if(screens.get(name) != null){   //screen loaded
         if(!getChildren().isEmpty()){    //if there is more than one screen
         getChildren().add(0, screens.get(name));     //add the screen
         screenToRemove = getChildren().get(1);
         getChildren().remove(1);                    //remove the displayed screen
         }else{
         getChildren().add(screens.get(name));       //no one else been displayed, then just show
         }
         return true;
         }else {
         System.out.println("screen hasn't been loaded!!! \n");
         return false;
         }*/
    }

    //This method will remove the screen with the given name from the collection of screens
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

}
