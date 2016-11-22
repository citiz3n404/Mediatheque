/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.util.Date;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Client {
    private String      ID_client;
    private String      firstName;
    private String      lastName;
    private Adress      adress;
    private Date        register_date;
    private Date        renewal_date;
    private int         nbLoanDone;
    private int         nbLoanDelayed;
    private int         nbCurrentLoan;
    private String      img;
    private ObservableList<Media> BorrowingList = FXCollections.observableArrayList();
    
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Client(String firstName, String lastName, Adress adress){
        this.ID_client          = UUID.randomUUID().toString();
        this.firstName          = firstName;
        this.lastName           = lastName;
        this.adress             = adress;
        this.register_date      = new Date();
        this.renewal_date       = new Date();
        this.nbLoanDone         = 0;
        this.nbLoanDelayed      = 0;
        this.nbCurrentLoan      = 0;
        this.img = "file:img/achille.jpg";
    }
    
    public Client(String firstName, String lastName, Adress adress, Date register_date, Date renewal_date, int nbLoanDone, int nbLoandDelayed, int nbCurrentLoan){
        this.ID_client          = UUID.randomUUID().toString();
        this.firstName          = firstName;
        this.lastName           = lastName;
        this.adress             = adress;
        this.register_date      = register_date;
        this.renewal_date       = renewal_date;
        this.nbLoanDone         = nbLoanDone;
        this.nbLoanDelayed      = nbLoandDelayed;
        this.nbCurrentLoan      = nbCurrentLoan;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the adress
     */
    public Adress getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    /**
     * @return the register_date
     */
    public Date getRegister_date() {
        return register_date;
    }

    /**
     * @param register_date the register_date to set
     */
    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    /**
     * @return the renewal_date
     */
    public Date getRenewal_date() {
        return renewal_date;
    }

    /**
     * @param renewal_date the renewal_date to set
     */
    public void setRenewal_date(Date renewal_date) {
        this.renewal_date = renewal_date;
    }

    /**
     * @return the nbLoanDone
     */
    public int getNbLoanDone() {
        return nbLoanDone;
    }

    /**
     * @param nbLoanDone the nbLoanDone to set
     */
    public void setNbLoanDone(int nbLoanDone) {
        this.nbLoanDone = nbLoanDone;
    }

    /**
     * @return the nbLoanDelayed
     */
    public int getNbLoanDelayed() {
        return nbLoanDelayed;
    }

    /**
     * @param nbLoanDelayed the nbLoanDelayed to set
     */
    public void setNbLoanDelayed(int nbLoanDelayed) {
        this.nbLoanDelayed = nbLoanDelayed;
    }

    /**
     * @return the nbCurrentLoan
     */
    public int getNbCurrentLoan() {
        return nbCurrentLoan;
    }

    /**
     * @param nbCurrentLoan the nbCurrentLoan to set
     */
    public void setNbCurrentLoan(int nbCurrentLoan) {
        this.nbCurrentLoan = nbCurrentLoan;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the BorrowingList
     */
    public ObservableList<Media> getBorrowingList() {
        return BorrowingList;
    }

    /**
     * @param BorrowingList the BorrowingList to set
     */
    public void setBorrowingList(ObservableList<Media> BorrowingList) {
        this.BorrowingList = BorrowingList;
    }

}
