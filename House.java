import java.util.ArrayList;

public class House extends Building {

    private ArrayList<String> residents; // List of residents
    private boolean hasDiningRoom; // Whether the house has a dining room

    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors); // Call Building's constructor
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        System.out.println("You have built a house: 🏠");
    }

    // Accessor for hasDiningRoom
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    // Returns the number of residents
    public int nResidents() {
        return this.residents.size();
    }

    // Move a resident into the house
    public void moveIn(String name) {
        this.residents.add(name);
    }

    // Move a resident out of the house
    public String moveOut(String name) {
        if (this.residents.contains(name)) {
            this.residents.remove(name);
            return name;
        } else {
            System.out.println(name + " is not a resident.");
            return null;
        }
    }

    // Check if a person is a resident
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    public static void main(String[] args) {
        House h = new House("Green House", "123 Main St", 3, true);
        h.moveIn("Alice");
        h.moveIn("Bob");
        System.out.println("Has dining room: " + h.hasDiningRoom());
        System.out.println("Number of residents: " + h.nResidents());
        System.out.println("Is Alice a resident? " + h.isResident("Alice"));
    }
}