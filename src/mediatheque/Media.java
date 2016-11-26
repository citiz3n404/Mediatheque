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
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public abstract class Media implements Serializable{
    private String ID_media;
    private String type;
    private String title;
    private String author;
    private LocalDate year;
    private boolean loanable;
    private boolean available;
    private int nbDispo;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Media(String title, String author, LocalDate year, boolean loanable, boolean available, int nbDispo, String type){
        this.ID_media   = UUID.randomUUID().toString();
        this.title      = title;
        this.author     = author;
        this.year       = year;
        this.loanable   = loanable;
        this.available  = available;
        this.nbDispo    = nbDispo;
        this.type       = type;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    
    public abstract double getCost();
    
    @Override
    public String toString(){
        return title;
    }

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the year
     */
    public LocalDate getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(LocalDate year) {
        this.year = year;
    }

    /**
     * @return the loanable
     */
    public boolean isLoanable() {
        return loanable;
    }

    /**
     * @param loanable the loanable to set
     */
    public void setLoanable(boolean loanable) {
        this.loanable = loanable;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the nbDispo
     */
    public int getNbDispo() {
        return nbDispo;
    }

    /**
     * @param nbDispo the nbDispo to set
     */
    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
