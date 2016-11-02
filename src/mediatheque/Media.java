/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.util.Date;
import java.util.UUID;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public abstract class Media {
    private String ID_media;
    private String title;
    private String author;
    private Date year;
    private boolean loanable;
    private boolean available;
    private int nbDispo;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Media(String title, String author, Date year, boolean loanable, boolean available, int nbDispo){
        this.ID_media   = UUID.randomUUID().toString();
        this.title      = title;
        this.author     = author;
        this.year       = year;
        this.loanable   = loanable;
        this.available  = available;
        this.nbDispo    = nbDispo;
        
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

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
    public Date getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Date year) {
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

}
