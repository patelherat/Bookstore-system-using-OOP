package hw05.hw5;

/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.System.exit;

/**
 * Store is the main class for a book store.
 */
public class Store {
    private static final char AUTHOR_SEARCH = 'a';
    private static final char MEDIA_SEARCH = 'm';
    private static final char TITLE_SEARCH = 't';
    private static final String CODES = Character.toString(AUTHOR_SEARCH)+Character.toString(MEDIA_SEARCH)+Character.toString(TITLE_SEARCH);
    private Scanner in;
    private List<Book> inventory = new ArrayList<>();
    private String name;
    private double rentalPrice;

    /**
     * Store default constructor initializes all its instance fields.
     */
    public Store(){
        name = "Barney's Books 'N' Bytes";
        rentalPrice = 3.95;
    }

    /**
     * list the inventory for a partial text string.
     * @param bk the book from which field has to be selected
     * @param code the code of the field to be selected
     * @return
     */
    private static String selectField(Book bk, char code){
        if(code == AUTHOR_SEARCH)
        {
            return bk.getAuthor();
        }
        else if(code == MEDIA_SEARCH)
        {
            return bk.getMedium();
        }
        else{
            return bk.getTitle();
        }
    }

    /**
     * Add a book to the store inventory
     * @param aBook the book to be added to the inventory
     */
    public void addBook(Book aBook){
        inventory.add(aBook);
    }

    public void fillInventory(String filename) throws FileNotFoundException{
        try {
            filename = Store.class.getResource("/hw05/resources/" + filename).getPath();
            File bookFile = new File(filename);
            in = new Scanner(bookFile);
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                if(produceBook(line)!=null)
                    addBook(produceBook(line));
            }
            in.close();
        }
        catch(Exception e){
            System.err.println("No such File found.");
            exit(0);
        }
    }

    /**
     * produceBook consumes a line of text and produces a Book instance.
     * @param line String containing details of the book to be produced
     * @return Book object produced from the details
     */
    public Book produceBook(String line){
        String[] bookDetails = line.split("_");
        if(bookDetails.length < 3 || bookDetails.length > 4){
            System.out.println("\"" + bookDetails[0] + "\" is not added to the inventory due to incorrect format");
            return null;
        }
        else if(!(Pattern.compile("^\\d+$").matcher(bookDetails[2]).matches()))
        {
            System.out.println("\"" + bookDetails[0] + "\" is not added to the inventory as the cost is either not specified or is not a valid number");
            return null;
        }
        Pattern pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        try {
            if (bookDetails[3].equals("leather") || bookDetails[3].equals("cloth")) {
                return new HardcoverBook(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]), bookDetails[3]);
            }
            else if(pattern.matcher(bookDetails[3]).matches()){
                return new ElectronicBook(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]), bookDetails[3]);
            }
            else if(Pattern.compile("^\\d+$").matcher(bookDetails[3]).matches()){
                return new AudioBook(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]), Integer.parseInt(bookDetails[3]));
            }
            else
            {
                System.out.println("\"" + bookDetails[0] + "\" is not added to the inventory as medium is \"" + bookDetails[3] + "\", which is invalid");
                return null;
            }
        }
        catch(ArrayIndexOutOfBoundsException ai){
            return new PaperbackBook(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]));
        }
    }

    /**
     * getMarkup returns the cost multiplier for price production.
     * @return Markup
     */
    public double getMarkup(){
        return 2.0;
    }

    /**
     * print the entire store inventory.
     */
    public void printInventory(){
        System.out.println("The inventory of " + name + ":");
        for(int i = 0; i < inventory.size(); i++){
            System.out.println((i+1) + ". " + inventory.get(i).toString());
        }
    }

    /**
     * list the inventory for a partial text string.
     * @param partText Text provided by user to search
     * @param code code of the field to be searched
     * @return
     */
    private List<Book> listMatching(String partText, char code){
        List<Book> matchingBooks = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++)
        {
            if(selectField(inventory.get(i), code).toLowerCase().contains(partText.toLowerCase())){
                matchingBooks.add(inventory.get(i));
            }
        }
        return matchingBooks;
    }

    /**
     * offerPurchase offers the user a choice from the list of books found.
     * @param bookList List of books that matched the search
     */
    private void offerPurchase(List<Book> bookList){
        if(bookList.size() == 0)
        {
            System.out.println("Sorry. No matches were found.");
            return;
        }

        for(int i=0; i<bookList.size(); i++) {
            System.out.println((i+1) + ". \"" + bookList.get(i).getTitle() + "\"");
            System.out.println("\t" + bookList.get(i).getMedium() + " $ " + String.format("%.2f", bookList.get(i).getCost()*getMarkup()));
        }
    }

    /**
     * offerSearch offers the user a way to search by title, author, or medium.
     */
    public void offerSearch(){
        in = new Scanner(System.in);
        String searchText = null;
        String[] search = null;
        while(true) {
            int flag=0;
            do{
                if(flag != 0)
                {
                    System.out.println("\n[usage: a|t|m part_text]");
                }

                System.out.print("\nEnter one of these one-letter codes: t(title), a(author), m(medium),\n" +
                        "and a portion of the desired text. Or enter a blank line to quit.\n" +
                        "\t(Note: medium is paper, hard, audio, or electronic).\n" +
                        "How would you like to search? ");

                searchText = in.nextLine();
                search = searchText.split(" ");

                if (searchText.isEmpty() || (search.length==1 && search[0].toLowerCase().equals("q")))
                {
                    System.out.println("\nSearch again any time!");
                    in.close();
                    exit(0);
                }

                flag++;
            }
            while(search.length != 2 || !(CODES.contains(search[0].toLowerCase())));

            List<Book> matchingBooks = new ArrayList<>();

            if (search[0].toLowerCase().equals("a")) {
                matchingBooks = listMatching(search[1], AUTHOR_SEARCH);
            }
            else if (search[0].toLowerCase().equals("m")) {
                matchingBooks = listMatching(search[1], MEDIA_SEARCH);
            } else {
                matchingBooks = listMatching(search[1], TITLE_SEARCH);
            }

            offerPurchase(matchingBooks);

            if(matchingBooks.size() != 0)
            {
                System.out.print("Which would you like to buy(ENTER to quit): ");
                Pattern pattern = Pattern.compile("^\\d+$");
                String choice = in.nextLine();
                while(!(pattern.matcher(choice).matches() && Integer.parseInt(choice)<=matchingBooks.size()))
                {
                    if (choice.isEmpty()) {
                        System.out.println("\nSearch again any time!");
                        in.close();
                        exit('0');
                    }
                    else
                    {
                        System.out.println("[usage: a number from the list above]");
                        System.out.print("Which would you like to buy(ENTER to quit): ");
                        choice = in.nextLine();
                    }
                }

                if (matchingBooks.get(Integer.parseInt(choice) - 1).getMedium().contains("Electronic") || matchingBooks.get(Integer.parseInt(choice)-1).getMedium().contains("Audio"))
                {
                    System.out.println("Sorry. \"" + matchingBooks.get(Integer.parseInt(choice) - 1).getTitle() + "\"");
                    System.out.println("\t\t" + matchingBooks.get(Integer.parseInt(choice) - 1).getMedium() + " is not for sale.");
                    System.out.println("\t\tThe rental price is $ " + rentalPrice + " per week.");
                }
                else
                {
                    System.out.println("The price of \"" + matchingBooks.get(Integer.parseInt(choice) - 1).getTitle() + "\" is $ " + String.format("%.2f", matchingBooks.get(Integer.parseInt(choice) - 1).getCost() * getMarkup()));
                }
            }
        }
    }

    /**
     * main method
     * @param args Name of file that contains the inventory
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        if (args.length != 1) {
            System.err.println("usage: java hw5.Store inventory_file");
            exit(1);
        }

        Store newStore = new Store();
        newStore.fillInventory(args[0]);
        newStore.printInventory();
        newStore.offerSearch();
    }
}
