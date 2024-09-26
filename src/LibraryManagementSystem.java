import java.util.Scanner;

public class LibraryManagementSystem {

    private Library library;

    public LibraryManagementSystem() {
        library = new Library();
    }

    // Main menu
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    library.addBook(isbn, title, author, year);
                    System.out.println("Book added successfully!");  // Success message
                    break;

                case 2:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    try {
                        library.borrowBook(borrowIsbn);
                        System.out.println("Book borrowed successfully!");  // Success message
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());  // Display error message
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    try {
                        library.returnBook(returnIsbn);
                        System.out.println("Book returned successfully!");  // Success message
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());  // Display error message
                    }
                    break;

                case 4:
                    System.out.println("Available Books:");
                    library.displayAvailableBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.start();
    }
}
