package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

/**
 * ElectronicBook represents an electronic book instance, an e-book.
 */
public class ElectronicBook extends Book {
    private static String theURL;

    /**
     * The ElectronicBook constructor instantiates the instance and initializes all its fields using the supplied arguments.
     * @param title
     * @param author
     * @param cost
     * @param theURL
     */
    public ElectronicBook(String title, String author, int cost, String theURL){
        super(title, author, cost, Medium.Electronic);
        this.theURL = theURL;
    }

    /**
     * The getMedium method returns the standard string medium representation plus the text " : {URL}".
     * @return String containing updated medium with the URL of the book
     */
    @Override
    public String getMedium(){
        return super.getMedium() + ": " + theURL;
    }

    /**
     * ElectronicBook instances are never offered for sale.
     * @return false
     */
    @Override
    public boolean isForSale() {
        return false;
    }

    /**
     * The toString represents an ElectronicBook by adding " from {URL}" to the standard string representation of a Book.
     * @return String containing updated medium with the URL of the book
     */
    @Override
    public String toString(){
        return super.toString() + " from " + theURL + ".";
    }

}
