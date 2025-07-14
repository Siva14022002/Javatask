//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//class Book {
//    private String title;
//    private String author;
//    private int year;
//
//
//    public Book(String title, String author, int year) {
//        this.title = title;
//        this.author = author;
//        this.year = year;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void display() {
//        System.out.println("- Title  : " + title);
//        System.out.println("- Author : " + author);
//        System.out.println("- Year   : " + year);
//        System.out.println();
//    }
//}
//
//class LibraryManager {
//    private ArrayList<Book> books;
//    private Scanner scanner;
//
//    public LibraryManager() {
//        books = new ArrayList<>();
//        scanner = new Scanner(System.in);
//    }
//
//    public void start() {
//        while (true) {
//            System.out.print("\nLibrary\n1. Add Book\n2. Display All Books\n3. Search Book by Title\n4. Delete Book by Title\n5. Exit\nEnter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            if (choice == 1) {
//                addBook();
//            } else if (choice == 2) {
//                displayBooks();
//            } else if (choice == 3) {
//                searchBook();
//            } else if (choice == 4) {
//                deleteBook();
//            } else if (choice == 5) {
//                System.out.println("Exiting the program...");
//                break;
//            } else {
//                System.out.println("Invalid choice. Try again.");
//            }
//        }
//    }
//
//    private void addBook() {
//        System.out.print("Enter book title: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Enter author name: ");
//        String author = scanner.nextLine();
//
//        System.out.print("Enter publication year: ");
//        int year = scanner.nextInt();
//        scanner.nextLine();
//
//        books.add(new Book(title, author, year));
//        System.out.println("Book added successfully!");
//    }
//
//    private void displayBooks() {
//        if (books.isEmpty()) {
//            System.out.println("No books available.");
//        } else {
//            System.out.println("\nList of Books:");
//            for (Book book : books) {
//                book.display();
//            }
//        }
//    }
//
//    private void searchBook() {
//        System.out.print("Enter part of the title to search: ");
//        String keyword = scanner.nextLine().toLowerCase();
//        boolean found = false;
//
//        for (Book book : books) {
//            if (book.getTitle().toLowerCase().contains(keyword)) {
//                if (!found) {
//                    System.out.println("\nMatching books:");
//                }
//                book.display();
//                found = true;
//            }
//        }
//
//        if (!found) {
//            System.out.println("No books found with that title.");
//        }
//    }
//
//    private void deleteBook() {
//        System.out.print("Enter the exact title of the book to delete: ");
//        String titleToDelete = scanner.nextLine();
//        boolean removed = false;
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
//                books.remove(i);
//                removed = true;
//                break;
//            }
//        }
//
//        if (removed) {
//            System.out.println("Book deleted successfully...");
//        } else {
//            System.out.println("Book not found...");
//        }
//    }
//}
//
//
//public class Library{
//    public static void main(String[] args) {
//        LibraryManager manager = new LibraryManager();
//        manager.start();
//    }
//}
//

import java.util.ArrayList;
import java.util.Scanner;

// Book Class
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

// Library Manager Class
class LibraryManager {

    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private boolean isAdmin = false;

    public void login() {
        System.out.print("Login as (1) Admin or (2) Student: ");
        int Type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (Type == 1 && username.equals("admin") && password.equals("admin123")) {
            isAdmin = true;
            System.out.println("Admin login successful!");
            start();
        } else if (Type == 2 && username.equals("student") && password.equals("student123")) {
            isAdmin = false;
            System.out.println("Student login successful!");
            start();
        } else {
            System.out.println("Invalid credentials. Try again.");
            login();
        }
    }

    public void start() {
        while (true) {
            System.out.println("\nLibrary Menu:");
            if (isAdmin) {
                System.out.println("1. Add Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search Book by Title");
                System.out.println("4. Delete Book by Title");
                System.out.println("5. Logout");
            } else {
                System.out.println("1. Display All Books");
                System.out.println("2. Search Book by Title");
                System.out.println("3. Logout");
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (isAdmin) {
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        displayBooks();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                    {
                        System.out.println("Logging out...");
                        login();
                        return;
                    }
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } else {
                switch (choice) {
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        searchBook();
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        login();
                        return;
                    default:
                    System.out.println("Invalid choice. Try again.");
                }
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
        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
                books.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Book deleted successfully...");
        } else {
            System.out.println("Book not found...");
        }
    }
}

// Main Class
public class Library {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.login();
    }
}
