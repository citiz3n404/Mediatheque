/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;

import java.io.Serializable;
import java.util.Date;



/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Video extends Media implements Serializable{
    private String legalDisclamer;
    private static int DURATION;
    private static double COST;
    
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Video(String title, String author, Date year, boolean loanable, boolean available, int nbDispo, String legalDisclamer){
        super(title, author, year, loanable, available, nbDispo, "VIDEO");
        this.legalDisclamer = legalDisclamer;
        this.DURATION = 20;
        this.COST = 8;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    @Override
    public String toString(){
        return "Disclamer : "+legalDisclamer;
    }

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************



    /**
     * @return the legalDisclamer
     */
    public String getLegalDisclamer() {
        return legalDisclamer;
    }

    /**
     * @param legalDisclamer the legalDisclamer to set
     */
    public void setLegalDisclamer(String legalDisclamer) {
        this.legalDisclamer = legalDisclamer;
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

    @Override
    public double getCost() {
        return COST;
    }

}
