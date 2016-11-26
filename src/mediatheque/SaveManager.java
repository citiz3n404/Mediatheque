/* 
 * Creation : 26 nov. 2016
 */
package mediatheque;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 * @date    26 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class SaveManager {
    Mediatheque m;
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public SaveManager(Mediatheque m){
        this.m = m;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void save() {
        try {
            // write object to file
            OutputStream fos = new FileOutputStream("save.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Client>(m.getClientsList()));
            oos.writeObject(new ArrayList<Media>(m.getMediasList()));
            oos.writeObject(new ArrayList<BorrowingCard>(m.getLoansList()));
            oos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void load(){
        try {
            InputStream in = new FileInputStream("save.txt");
            ObjectInputStream ois = new ObjectInputStream(in);
            List<Client> list = (List<Client>) ois.readObject() ;
            List<Media> listm = (List<Media>) ois.readObject();
            List<BorrowingCard> listbc = (List<BorrowingCard>) ois.readObject();
            m.setClientsList(FXCollections.observableList(list));
            m.setMediasList(FXCollections.observableList(listm));
            m.setLoansList(FXCollections.observableList(listbc));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            //return FXCollections.emptyObservableList();
    }
    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

}
