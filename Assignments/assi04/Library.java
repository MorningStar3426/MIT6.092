import java.util.ArrayList;
import java.util.List;

public class Library {
    String address;
    static String openingHours = "Libraries are open daily from 9am to 5pm.";
    ArrayList<Book> collections;
    int numOfBooks;


    public Library(){
    }

    public Library(String address){
        this.address = address;
        this.collections = new ArrayList<>();
        this.numOfBooks = 0;
    }

    public static void printOpeningHours(){
        System.out.println(openingHours);
    }

    public void addBook(Book newBook){
        this.collections.add(newBook);
        this.numOfBooks += 1;
    }

    public void printAddress(){
        System.out.println(address);
    }

    public void borrowBook(String title){
        boolean find = false;
        for (int i = 0;i < this.numOfBooks; i++){
            // 这里获取的实际上是collections里边对应元素的一个饮用
            // 对book的行为实际上是在修改 collections 列表中该位置的 Book 对象的状态。
            Book tmp = this.collections.get(i);
            if (tmp.getTitle().equals(title)){
                find = true;
                if (tmp.isBorrowed()){
                    System.out.println("Sorry, this book is already borrowed.");
                    break;
                }else {
                    tmp.rented();
                    System.out.println("You successfully borrowed " + title);
                    break;
                }
            }
        }
        if (!find){
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void printAvailableBooks(){
        boolean flag = false;
        for (int i = 0; i< collections.size(); i++){
            Book tmp = collections.get(i);
            if (!tmp.isBorrowed()){
                System.out.println(tmp.getTitle());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("No book in catalog");
        }
    }

    public void returnBook(String title){
        for (int i = 0; i < collections.size(); i++){
            Book tmp = collections.get(i);
            if (tmp.getTitle().equals(title) && tmp.isBorrowed()){
                tmp.returned();
                System.out.println("You successfully returned " + title);
            }
        }
    }
// Add the missing implementation to this class

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 