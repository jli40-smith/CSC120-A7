/**
 * A Building which keeps count of an inventory of coffee 
 * components which can be sold and restocked
 * @author Joanna Li
 * @version 11/07/2022
 */
public class Cafe extends Building {
    
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a default Cafe with an empty inventory
     */
    public Cafe() {
        super();

        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;

        System.out.println("You have built a cafe");
    }
    
    /**
     * Constructs a Cafe
     * @param name String name of the cafe 
     * @param address String street address of the cafe 
     * @param nFloors int equal to the number of floors in the cafe 
     * @param nCoffeeOunces int ounces of coffee left in the inventory 
     * @param nSugarPackets int number of sugar packets left in the inventory 
     * @param nCreams int number of creams left in the inventory 
     * @param nCups int number of coffee cups left in the inventory 
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);

        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        System.out.println("You have built a cafe");
    }

    /**
     * Sells a default order of coffee and restocks the inventory items sold
     */
    public void sellCoffee() {
        this.nCoffeeOunces -= 2;
        this.nSugarPackets -= 1;
        this.nCreams -= 2;
        this.nCups -= 1; 

        restock(2, 1, 2, 1);
    }
    
    /**
     * Sells a cup of coffee and restocks inventory items that run out 
     * @param nCoffeeOunces int ounces of coffee sold
     * @param nSugarPackets int number of sugar packets sold 
     * @param nCreams int number of creams sold 
     */
    public void sellCoffee(int nCoffeeOunces, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces -= nCoffeeOunces;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;

        if (this.nCoffeeOunces <= 0) { 
            System.out.println("Ran out of coffee, restocked 100 more");
            this.restock(100, 0, 0, 0);
        }
        
        if (this.nSugarPackets <= 0) { 
            System.out.println("Ran out of sugar packets, restocked 100 more");
            this.restock(0, 100, 0, 0);
        }
        
        if (this.nCreams <= 0) { 
            System.out.println("Ran out of creams, restocked 100 more");
            this.restock(0, 0, 100, 0);
        }

        
        if (this.nCups <= 0) { 
            System.out.println("Ran out of cups, restocked 100 more");
            this.restock(0, 0, 0, 100);
        }
    }

    /**
     * Restocks the Cafe inventory by adding the given amounts 
     * of coffee ingredients and cups to the inventory counts
     * 
     * @param nCoffeeOunces int ounces of coffee to restock 
     * @param nSugarPackets int number of sugar packets to restock 
     * @param nCreams int number of creams to restock 
     * @param nCups int number of cups to restock 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Prints list of available methods
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(n,n,n)\n + restock(n,n,n,n)\n");
    }

  /**
   * Allows movement to the first floor 
   * @param floorNum int number of the floor to move to, should be equal to 1
   * @throws RuntimeException if floorNum is not equal to 1
   */
    public void goToFloor(int floorNum) {
        if (floorNum == 1) {
        super.goToFloor(floorNum);
        } else { 
            throw new RuntimeException("You can only access the first floor of Cafes");
        }    
    }

    /**
     * Main method for testing Cafe methods
     * @param args String array with command-line arguments
     */
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "Neilson Drive", 2, 51, 0, 0, 1);
        
        compassCafe.showOptions();

        //Testing sell and auto restock
        compassCafe.sellCoffee(50, 50, 50);
        System.out.println("Cups: " + compassCafe.nCups);
        System.out.println("Coffee: " +compassCafe.nCoffeeOunces);
        System.out.println("Sugar packets " +compassCafe.nSugarPackets);
        System.out.println("Creams " +compassCafe.nCreams);
        
        //Test 2 for sell and auto restock
        compassCafe.sellCoffee(10, 10, 10);
        System.out.println("Cups: " + compassCafe.nCups);
        System.out.println("Coffee: " +compassCafe.nCoffeeOunces);
        System.out.println("Sugar packets " +compassCafe.nSugarPackets);
        System.out.println("Creams " +compassCafe.nCreams);

        compassCafe.enter(); 
        compassCafe.goToFloor(1);
        //compassCafe.goToFloor(2); //This causes a RuntimeException because you can only access the first floor of Cafes

        /* Testing the default order of coffee
        for (int i=0; i<10; i++) {
            compassCafe.sellCoffee(); //The inventory numbers stay the same, showing that the default order is being  restocked each time it is sold
            System.out.println("Cups: " + compassCafe.nCups);
            System.out.println("Coffee: " +compassCafe.nCoffeeOunces);
            System.out.println("Sugar packets " +compassCafe.nSugarPackets);
            System.out.println("Creams " +compassCafe.nCreams);
        }
        */
        
        /*Testing the default constructor */
        Cafe defaultCafe = new Cafe(); 
        System.out.println("Cups: " + defaultCafe.nCups);
        System.out.println("Coffee: " + defaultCafe.nCoffeeOunces);
        System.out.println("Sugar packets " + defaultCafe.nSugarPackets);
        System.out.println("Creams " + defaultCafe.nCreams);
    }
    
}
