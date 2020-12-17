package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

/**
 * The Book class represents the common characteristics of a book, which may be produced in various medium formats.
 */
public abstract class Book {
    private String author;
    private int cost;
    private Medium medium;
    private String title;

    /**
     * The Book constructor instantiates the instance with the specified values.
     * @param title
     * @param author
     * @param cost
     * @param medium
     */
    public Book(String title, String author, int cost, Medium medium){
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.medium = medium;
    }

    /**
     * getter method for the author's name
     * @return author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * converts the cost into dollars and cents
     * @return converted cost
     */
    public double getCost() {
        double dollars = cost/100;
        return dollars;
    }

    /**
     * getMedium gets the 'display string representation' of the book's medium.
     * @return Medium's String representation
     */
    public String getMedium() {
        return medium.toString();
    }

    /**
     * Getter method for the title of the book
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * The standard string representation prints the title on the first line, followed by the author on the second line, and the book medium on the third line.
     * @return String with title, author and medium of the book
     */
    @Override
    public String toString(){
        return "\""+getTitle()+"\".\n\t\t"+getAuthor()+".\n\t\t"+medium;
    }

    /**
     * The isForSale implementation depends on the book's medium.
     * @return is the book for sale or not
     */
    public abstract boolean isForSale();

}
