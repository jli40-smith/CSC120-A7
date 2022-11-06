import java.util.ArrayList;

/**
 * A Building which tracks the residents 
 * living in a Smith house
 * @author Joanna Li 
 * @version 11/02/2022
 */
public class House extends Building {

  private  boolean hasDiningRoom;
  private boolean hasElevator; 
  private ArrayList<String> residents;

  /**
   * Constructs a House 
   * @param name String name of the house 
   * @param address String street address of the house 
   * @param nFloors int number of floors in the house 
   * @param hasDiningRoom boolean indicating if the house has a dining room 
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    
    super(name, address, nFloors);
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house");
  }
  
  /**
   * Checks if a house has a dining room
   * @return boolean indicating if the house has a dining room 
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom; 
  }

  /** 
   * Returns the number of residents living in the house
   * @return int number of residents living in the house
   */
  public int nResidents() { 
    return residents.size(); 
  }
  /** 
   * Adds a resident to the house 
   * @param name String name of the resident moving in 
   */
  public void moveIn(String name) { 
    residents.add(name); 
  }
  
  /** 
   * Removes a resident from the house 
   * @param name String name of the resident moving out 
   */
  public String moveOut(String name) { 
    residents.remove(name);
    return name;
  }

  /** 
   * Checks if a person is a resident of the house
   * @param person String name of the person to check for in the house
   * @return boolean indicating if the person is a resident of the house 
   */
  public boolean isResident(String person) { 
    return residents.contains(person); 
  }
  
  /**
   * Prints list of available methods for the House 
   */
  public void showOptions() {
    super.showOptions(); 
    System.out.println(" + hasDiningRoom()\n + nResidents()\n + moveIn(\"\")\n + moveOut(\"\") \n + isResident(\"\")\n");
}

  /**
   * Allows movement to nonadjacent floors 
   * @param floorNum int number of the floor to move to, should be in valid range of floors for the House
   * @throws RuntimeException if the House does not have an elevator 
   */
  public void goToFloor(int floorNum) {
    /*Allows movement between nonadjacent floors if elevator is present*/
    if (!hasElevator) { 
      throw new RuntimeException("This building doesn't have an elevator, use goUp() or goDown() to move one floor at a time"); 
    }
    super.goToFloor(floorNum);
  }

    /**
     * Main method for testing House methods
     * @param args String array with command-line arguments
     */
  public static void main(String[] args) {

    House lamontHouse = new House("Lamont", "Prospect Street", 4, true, true);

    System.out.println(lamontHouse);
    lamontHouse.showOptions();
    System.out.println(lamontHouse.hasDiningRoom());
    
    lamontHouse.moveIn("Jenny");
    System.out.println(lamontHouse.nResidents());

    lamontHouse.moveIn("Jared");
    System.out.println(lamontHouse.nResidents());

    System.out.println(lamontHouse.moveOut("Jared"));
    System.out.println(lamontHouse.isResident("Jared"));

    lamontHouse.enter(); 
    lamontHouse.goToFloor(3);

    House albrightHouse = new House("Albright", "Street", 4, true, false);
    albrightHouse.enter(); 
    albrightHouse.goToFloor(3);
  }

}