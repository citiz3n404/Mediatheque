/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.util.Date;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Livre extends Media{
    private int nbPage;
    private static int DURATION;
    private static double COST;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Livre(String title, String author, Date year, boolean loanable, boolean available, int nbDispo, int pages){
        super(title, author, year, loanable, available, nbDispo, "BOOK");
        this.DURATION = 15;
        this.COST = 3;
        this.nbPage = pages;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************

    @Override
    public double getCost() {
        return COST;
    }
    @Override
    public String toString(){
        return "Pages : "+nbPage;
    }
    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the nbPage
     */
    public int getNbPage() {
        return nbPage;
    }

    /**
     * @param nbPage the nbPage to set
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

     /**
     * @return the DURATION
     */
    public static int getDURATION() {
        return DURATION;
    }

    /**
     * @param aDURATION the DURATION to set
     */
    public static void setDURATION(int aDURATION) {
        DURATION = aDURATION;
    }

    /**
     * @return the COST
     */
    public static double getCOST() {
        return COST;
    }

    /**
     * @param aCOST the COST to set
     */
    public static void setCOST(double aCOST) {
        COST = aCOST;
    }
}
