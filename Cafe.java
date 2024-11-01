public class Cafe extends Building {

    private int nCoffeeOunces; // Coffee in ounces
    private int nSugarPackets; // Sugar packets
    private int nCreams; // Cream portions
    private int nCups; // Cups available

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    // Sell a cup of coffee and adjust inventory
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(50, 20, 20, 10); // Restock if necessary
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    // Private method to restock inventory
    private void restock(int coffee, int sugar, int cream, int cups) {
        this.nCoffeeOunces += coffee;
        this.nSugarPackets += sugar;
        this.nCreams += cream;
        this.nCups += cups;
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Campus Cafe", "789 University Rd", 1, 100, 50, 30, 20);
        cafe.sellCoffee(12, 2, 3);
    }
}