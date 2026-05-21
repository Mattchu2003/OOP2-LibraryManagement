import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {

            book.displayBook();

            if (book.isBorrowed()) {
                System.out.println("Status: Borrowed");
            } else {
                System.out.println("Status: Available");
            }

            System.out.println();
        }
    }

    public void borrowBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {

                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book already borrowed.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {

                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}
