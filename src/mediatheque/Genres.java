/* 
 * Creation : 2 nov. 2016
 */
package mediatheque;



/**
 * @date    2 nov. 2016
 * @author  Anthony CHAFFOT
 * @author  Benjamin KRAFFT
 */
public class Genres {
    private String      name;
    private String      img;
    private int         nbLoan;
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Genres(String name, String img, int nbLoan){
        this.name       = name;
        this.img        = img;
        this.nbLoan     = nbLoan;    
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void increment(){
        nbLoan++;
    }
    
    public void decrease(){
        if (nbLoan-1<0){
            nbLoan=0;
        }
        else{
            nbLoan--;
        }
    }
    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the nbLoan
     */
    public int getNbLoan() {
        return nbLoan;
    }

    /**
     * @param nbLoan the nbLoan to set
     */
    public void setNbLoan(int nbLoan) {
        this.nbLoan = nbLoan;
    }

}
