package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

/**
 * AudioBook is a book delivered as audio compact discs (CD).
 */
public class AudioBook extends Book {
    private int numDiscs;

    /**
     * The constructor instantiates this particular kind of Book instance.
     * @param title
     * @param author
     * @param cost
     * @param numDiscs
     */
    public AudioBook(String title, String author, int cost, int numDiscs){
        super(title, author, cost, Medium.Audio);
        this.numDiscs = numDiscs;
    }

    /**
     * The getMedium method adds the number of discs to the string representation of this instance's medium format.
     * @return String containing updated medium with the number of discs
     */
    @Override
    public String getMedium(){
        return super.getMedium() + ": " + numDiscs + " discs.";
    }

    /**
     * AudioBook instances are never offered for sale; they are rental only.
     * @return false
     */
    @Override
    public boolean isForSale() {
        return false;
    }

    /**
     * The toString represents an AudioBook by adding ": {n} disks." to the standard string representation of a Book.
     * @return String containing updated medium with the number of discs
     */
    @Override
    public String toString(){
        return super.toString() + ": " + numDiscs + " discs.";
    }
}
