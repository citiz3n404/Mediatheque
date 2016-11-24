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
public class Audio extends Media{
    private String classification;
    private static int DURATION;
    private static double COST;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Audio(String title, String author, Date year, boolean loanable, boolean available, int nbDispo, String classification){
        super(title, author, year, loanable, available, nbDispo, "AUDIO");
        this.classification = classification;
        this.DURATION = 20;
        this.COST = 10;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    @Override
    public String toString(){
        return "Classification : "+classification;
    }
    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification) {
        this.classification = classification;
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
