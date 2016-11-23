/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Mediatheque {
    private String name;
    
    private ObservableList<Client> clientsList = FXCollections.observableArrayList();
    private ObservableList<Media> mediasList = FXCollections.observableArrayList();
    private TempCart tempCart;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Mediatheque(String name){
        this.name = name;
        this.tempCart = new TempCart();
        
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void addMedia(Media media){
        getMediasList().add(media);
    }
    
    public void addCLient(Client client){
        getClientsList().add(client);
    }
    

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the mediasList
     */
    public ObservableList<Media> getMediasList() {
        return mediasList;
    }

    /**
     * @param mediasList the mediasList to set
     */
    public void setMediasList(ObservableList<Media> mediasList) {
        this.mediasList = mediasList;
    }

    /**
     * @return the clientsList
     */
    public ObservableList<Client> getClientsList() {
        return clientsList;
    }

    /**
     * @param clientsList the clientsList to set
     */
    public void setClientsList(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tempCart
     */
    public TempCart getTempCart() {
        return tempCart;
    }

    /**
     * @param tempCart the tempCart to set
     */
    public void setTempCart(TempCart tempCart) {
        this.tempCart = tempCart;
    }

}
