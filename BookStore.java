import java.util.Scanner;
    
class Book {
    private String name;
    private String author;
    private double price;
    private int num_pages;

    // Constructor
    public Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return num_pages;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    // toString method to display book details
    @Override
    public String toString() {
        return "Book Name: " + name + "\nAuthor: " + author + 
               "\nPrice: $" + price + "\nNumber of Pages: " + num_pages;
    }
}

public class BookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of Pages: ");
            int num_pages = sc.nextInt();
            sc.nextLine(); // consume the newline

            books[i] = new Book(name, author, price, num_pages);
        }

        System.out.println("\nDetails of all books:");
        for (Book book : books) {
            System.out.println("--------------------");
            System.out.println(book.toString());
        }

        sc.close();
    }
}
