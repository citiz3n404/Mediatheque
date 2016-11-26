/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;



/**
 * @date    2 nov. 2016
 * @author  Anthony CHAFFOT
 * @author  Benjamin KRAFFT
 */
public class BorrowingCard implements Serializable{
    private LocalDate        loanDate;
    private LocalDate        limitDate;
    private LocalDate       reminderDate;
    private boolean     overDated;
    private double      cost;
    private Client      client;
    private Media       media;
    private String      ID_card;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public BorrowingCard(LocalDate loanDate, LocalDate limitDate, LocalDate  reminderDate,boolean overDated, double cost, Client client, Media media){
        this.loanDate       = loanDate;
        this.limitDate      = limitDate;
        this.reminderDate   = reminderDate;
        this.overDated      = overDated;
        this.cost           = cost;
        this.ID_card        = UUID.randomUUID().toString();
        this.client         = client;
        this.media          = media;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the loanDate
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate the loanDate to set
     */
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * @return the limitDate
     */
    public LocalDate getLimitDate() {
        return limitDate;
    }

    /**
     * @param limitDate the limitDate to set
     */
    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    /**
     * @return the reminderDate
     */
    public LocalDate getReminderDate() {
        return reminderDate;
    }

    /**
     * @param reminderDate the reminderDate to set
     */
    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    /**
     * @return the overDated
     */
    public boolean isOverDated() {
        return overDated;
    }

    /**
     * @param overDated the overDated to set
     */
    public void setOverDated(boolean overDated) {
        this.overDated = overDated;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

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
     * @return the media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Media media) {
        this.media = media;
    }

   

}
