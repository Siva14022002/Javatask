import java.util.ArrayList;
import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private int year;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void display() {
        System.out.println("- Title  : " + title);
        System.out.println("- Author : " + author);
        System.out.println("- Year   : " + year);
        System.out.println();
    }
}

class LibraryManager {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibraryManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("\n==== Library Menu ====\n1. Add Book\n2. Display All Books\n3. Search Book by Title\n4. Delete Book by Title\n5. Exit\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                displayBooks();
            } else if (choice == 3) {
                searchBook();
            } else if (choice == 4) {
                deleteBook();
            } else if (choice == 5) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(title, author, year));
        System.out.println("Book added successfully!");
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nList of Books:");
            for (Book book : books) {
                book.display();
            }
        }
    }

    private void searchBook() {
        System.out.print("Enter part of the title to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword)) {
                if (!found) {
                    System.out.println("\nMatching books:");
                }
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    private void deleteBook() {
        System.out.print("Enter the exact title of the book to delete: ");
        String titleToDelete = scanner.nextLine();
        boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(titleToDelete));

        if (removed) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}


public class Library{
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.start();
    }
}

