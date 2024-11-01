import java.util.Hashtable;

public class Library extends Building {

    private Hashtable<String, Boolean> collection; // Collection of books

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library: 📚");
    }

    // Add a title to the collection
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    // Remove a title from the collection
    public String removeTitle(String title) {
        return this.collection.remove(title) != null ? title : null;
    }

    // Check out a book
    public void checkOut(String title) {
        if (this.collection.containsKey(title) && this.collection.get(title)) {
            this.collection.put(title, false);
        } else {
            System.out.println(title + " is not available.");
        }
    }

    // Return a book
    public void returnBook(String title) {
        if (this.collection.containsKey(title) && !this.collection.get(title)) {
            this.collection.put(title, true);
        } else {
            System.out.println(title + " is not checked out.");
        }
    }

    // Check if a title exists in the collection
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    // Check if a book is available
    public boolean isAvailable(String title) {
        return this.collection.getOrDefault(title, false);
    }

    // Print the entire collection with availability
    public void printCollection() {
        for (String title : this.collection.keySet()) {
            System.out.println(title + " - " + (this.collection.get(title) ? "Available" : "Checked out"));
        }
    }

    public static void main(String[] args) {
        Library lib = new Library("Campus Library", "456 College Ave", 4);
        lib.addTitle("The Great Gatsby by F. Scott Fitzgerald");
        lib.addTitle("1984 by George Orwell");
        lib.printCollection();
        lib.checkOut("1984 by George Orwell");
        System.out.println("Is '1984' available? " + lib.isAvailable("1984 by George Orwell"));
    }
}