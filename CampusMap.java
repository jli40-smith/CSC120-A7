import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        /*Adding 10 more examples of Building and Building subclasses */
        myMap.addBuilding(new House("Lamont House", "Prospect St, Northampton, MA 01060", 4, true, true));
        myMap.addBuilding(new House("Chase House", "Elm St, Northampton, MA 01060", 4, true, true));
        myMap.addBuilding(new House("Albright House", "7, Bedford Terrace, Northampton, MA 01063", 4, false, false)); 

        myMap.addBuilding(new Library("New Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Werner Josten Library ", "Mendenhall Center, 122 Green St, Northampton, MA 01063", 3));
        
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 1, 100, 100, 100, 100));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "Smith College Campus Center, 100 Elm St, Northampton, MA 01063", 1, 100, 100, 100, 100));

        myMap.addBuilding(new Building("McConnell Hall", "01063, 2 Tyler Ct, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Hatfield Hall", "Smith College, Northampton, MA 01063", 3));

        System.out.println(myMap);
    }
    
}
