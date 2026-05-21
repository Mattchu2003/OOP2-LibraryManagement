import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Clean Code", "Robert Martin"));

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
