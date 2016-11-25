package mediatheque;

/* 
 * Creation : 2 nov. 2016
 */




/**
 * @date    2 nov. 2016
 * @author  Benjamin KRAFFT
 * @author  Anthony CHAFFOT
 */
public class Adress {
    private int         number;
    private String      street;
    private String      country;
    private int         zipcode;
    private String      city;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Adress(){
        this.number     = 0;
        this.street     = "street";
        this.country    = "country";
        this.city       = "city";
        this.zipcode    = 0;
    }
    
    public Adress(int number, String street, String country, String city,int zipcode){
        this.number     = number;
        this.street     = street;
        this.country    = country;
        this.city       = city;
        this.zipcode    = zipcode;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    
    public String toString(){
        return number+" "+street+", "+ zipcode+" "+ city+", "+ country;
    }

    //**************************************************************************
    // SETTERS / GETTERS
    //**************************************************************************

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
