import java.util.Hashtable;
import java.util.Set;

/**
 * A Building which tracks a collection of book titles and author 
 * infomation along with each book's availability status
 * @author Joanna Li 
 * @version 11/07/2022
 */
public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator = true;

    /**
     * Default constructor for Library
     * @param nFloors int number of floors in the new Library 
     */
    public Library(int nFloors) {
        super();
        collection = new Hashtable<String, Boolean>();
        this.nFloors = nFloors;
    }

    /**
     * Constructs a Library
     * @param name String name of the library
     * @param address String street address of the library 
     * @param nFloors int number of floors in the Library 
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library");
    }
  
    /**
     * Adds a book to the library 
     * @param title String with the title and author of the book to be added 
     */
    public void addTitle(String title) {
        collection.put(title, true);
        System.out.println("You have added " + title + " to the collection");
    }

    /**
     * Removes a book from the library
     * @param title String with the title and author of the book to be removed
     * @return String with the title and author of the book that was removed
     */
    public String removeTitle(String title) {
        collection.remove(title);
        System.out.println("You have removed " + title + " from the collection");
        return title;
    }

    /**
     * Changes the availability status of a book to false and checks it out 
     * @param title String with the title and author of the book to check out 
     */
    public void checkOut(String title) {
        collection.replace(title, true, false);
        System.out.println("You have checked out " + title);
    }
    
    /** 
     * Changes the availability status o a book to true and returns it to the collection
     * @param title String with the title and author of the book to return 
     */
    public void returnBook(String title) {
        collection.replace(title, false, true);
        System.out.println("You have returned " + title);
    }

    /** 
     * Checks if a book is in the collection
     * @param title String with title and author of the book to check for
     * @return boolean indicating if the book is in the collection 
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /** 
     * Checks if a book's availability status is true
     * @param title String with title and author of the book to check for availability 
     * @return boolean indicating if the book is available 
     */
    public boolean isAvailable(String title) {
        return collection.get(title);
    }
    
    /**
     * Prints out the books in the library with their availability status 
     */
    public void printCollection() {
        Set<String> allTitles = collection.keySet(); //Source [1]

        System.out.println("********Library Catalog********");

        for (String title : allTitles) {
          System.out.println("Title and Author: " + title);
          System.out.print("Status: ");

          if (!collection.get(title)) {
            System.out.println("Checked out");
          } else {
            System.out.println("Available");
          }

        System.out.println("*******************************");
        }
    }

    /** 
     * Prints out the books in the library with their availability status in csv format
     * @param csv String which should be equal to "csv" (non case-sensitive) for the collection to be displayed in .csv format
     */
    public void printCollection(String csv) {
        csv = csv.toLowerCase();

        if (csv.equals("csv")) {
          Set<String> allTitles = collection.keySet(); //Source [1]

          System.out.println("Title and Author,Availability");

          for (String title : allTitles) {
            System.out.print("\"" + title + "\",");
          
            if (!collection.get(title)) {
              System.out.println("0");
            } else {
              System.out.println("1");
            }
          } 
        } else {
            System.out.println("To display the collection in csv format, enter \"csv\" as the parameter for printCollection()");
        }
    }
    
    /**
     * Prints list of available methods
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(\"\")\n + removeTitle(\"\") \n + checkOut(\"\")\n + returnBook(\"\")\n + containsTitle(\"\")\n + isAvailable(\"\")\n + printCollection()\n");
}

  /**
   * Allows movement to nonadjacent floors
   * @param floorNum int number of the floor to move to, should be in valid range of floors for the Library
   * @throws RuntimeException if the Library does not have an elevator
   */
    public void goToFloor(int floorNum) {
        if (!hasElevator) { 
           throw new RuntimeException("This building doesn't have an elevator, use goUp() or goDown() to move one floor at a time"); 
        }  
        super.goToFloor(floorNum);
    }

    /**
     * Main method for testing Library methods
     * @param args String array with command-line arguments
     */
    public static void main(String[] args) {

        Library neilsonLibrary = new Library("Neilson Library", "Neilson Drive", 4);
        neilsonLibrary.showOptions();

        //Add a book and verify that it worked
        neilsonLibrary.addTitle("The Wealth of Nations by Adam Smith");
        System.out.println(neilsonLibrary.containsTitle("The Wealth of Nations by Adam Smith"));

        //Check out the book and verify that it worked
        neilsonLibrary.checkOut("The Wealth of Nations by Adam Smith");
        System.out.println(neilsonLibrary.isAvailable("The Wealth of Nations by Adam Smith"));

        //Return the book and verify that it worked
        neilsonLibrary.returnBook("The Wealth of Nations by Adam Smith");
        System.out.println(neilsonLibrary.isAvailable("The Wealth of Nations by Adam Smith"));

        //Remove the book and verify that it worked
        neilsonLibrary.removeTitle("The Wealth of Nations by Adam Smith");
        System.out.println(neilsonLibrary.containsTitle("The Wealth of Nations by Adam Smith"));

        //Testing the printCollection() method
        neilsonLibrary.addTitle("The Social Contract by Jean-Jacques Rousseau");
        neilsonLibrary.addTitle("Anarchy, State, and Utopia by Robert Nozick");

        neilsonLibrary.checkOut("Anarchy, State, and Utopia by Robert Nozick");

        //Print the collection
        neilsonLibrary.printCollection();

        //Print collection in csv format
        neilsonLibrary.printCollection("csv");
        neilsonLibrary.printCollection("CSV");
      
        /*Testing movement between floors */
        neilsonLibrary.enter(); 
        neilsonLibrary.goToFloor(4);
        neilsonLibrary.goDown();
        neilsonLibrary.goToFloor(1);
        neilsonLibrary.exit(); 

        /*Test default constructor */
        Library defaultLibrary = new Library(3);
        defaultLibrary.enter(); 
        defaultLibrary.goToFloor(3);
      }
  
}