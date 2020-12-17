package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

/**
 * PaperbackBook represents a basic paperback book.
 */
public class PaperbackBook extends Book {

    /**
     * The PaperbackBook constructor instantiates and initializes the instance.
     * @param title
     * @param author
     * @param cost
     */
    public PaperbackBook(String title, String author, int cost){
        super(title, author, cost, Medium.Paperback);
    }

    /**
     * PaperbackBook instances are always offered for sale.
     * @return true
     */
    @Override
    public boolean isForSale() {
        return true;
    }

    /**
     * toString adds a trailing period(.) at the end of the returned text.
     * @return updated String
     */
    @Override
    public String toString(){
        return super.toString() + ".";
    }
}
