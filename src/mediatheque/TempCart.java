package mediatheque;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediatheque.Client;
import mediatheque.Media;

/* 
 * Creation : 22 nov. 2016
 */



/**
 * @date    22 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class TempCart {
    private Client client = new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250),"file:img/profil.png");;
    private ObservableList<Media> medias = FXCollections.observableArrayList();

    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public TempCart(){
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the medias
     */
    public ObservableList<Media> getMedias() {
        return medias;
    }

    /**
     * @param medias the medias to set
     */
    public void setMedias(ObservableList<Media> medias) {
        this.medias = medias;
    }

}
