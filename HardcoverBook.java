package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

/**
 * HardcoverBook represents books with hard covers.
 */
public class HardcoverBook extends Book {
    private String coverMaterial;

    /**
     * The HardcoverBook constructor instantiates the instance by initializing all the fields with the specified values.
     * @param title
     * @param author
     * @param cost
     * @param coverMaterial
     */
    public HardcoverBook(String title, String author, int cost, String coverMaterial){
        super(title, author, cost, Medium.Hardcover);
        this.coverMaterial = coverMaterial;
    }

    /**
     * The getMedium method extends the standard medium information string by adding text describing the cover material of this instance.
     * @return String containing updated medium with the cover material
     */
    @Override
    public String getMedium(){
        return super.getMedium() + " " + coverMaterial + ".";
    }

    /**
     * HardcoverBook instances are always offered for sale.
     * @return true
     */
    @Override
    public boolean isForSale() {
        return true;
    }

    /**
     * The toString represents an HardcoverBook by adding " {cover material}." to the standard string representation of a Book.
     * @return String containing updated medium with the cover material
     */
    @Override
    public String toString(){
        return super.toString() + " " + coverMaterial + ".";
    }

}
