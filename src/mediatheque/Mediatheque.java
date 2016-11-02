/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.util.ArrayList;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Mediatheque {
    private String name;
    private ArrayList<Media> medias = new ArrayList<>();
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Mediatheque(String name){
        this.name = name;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void addMedia(Media media){
        medias.add(media);
    }

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

}
