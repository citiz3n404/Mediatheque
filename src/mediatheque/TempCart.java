package mediatheque;


import java.util.ArrayList;
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
    private Client client;
    private ArrayList<Media> medias;

    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public TempCart(){
        client = new Client("Anthony", "CHAFFOT", new Adress(1, "Rue kleber", "France", "LGC", 92250));
        medias = new ArrayList<>();
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
    public ArrayList<Media> getMedias() {
        return medias;
    }

    /**
     * @param medias the medias to set
     */
    public void setMedias(ArrayList<Media> medias) {
        this.medias = medias;
    }

}
