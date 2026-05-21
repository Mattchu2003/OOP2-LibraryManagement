package oop;

import java.time.LocalDate;

public class BorrowRecord {
    private String recordId;
    private String memberId;
    private String bookId;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    private boolean returned;

    public BorrowRecord(String recordId, String memberId, String bookId, String bookTitle) {
        this.recordId   = recordId;
        this.memberId   = memberId;
        this.bookId     = bookId;
        this.bookTitle  = bookTitle;
        this.borrowDate = LocalDate.now();
        this.dueDate    = borrowDate.plusDays(Book.BORROW_DAYS);
        this.returned   = false;
        this.fine       = 0;
    }

    public void markReturned(double fine) {
        this.returnDate = LocalDate.now();
        this.fine       = fine;
        this.returned   = true;
    }

    public String getRecordId()   { return recordId; }
    public String getMemberId()   { return memberId; }
    public String getBookId()     { return bookId; }
    public String getBookTitle()  { return bookTitle; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate()    { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public double getFine()       { return fine; }
    public boolean isReturned()   { return returned; }

    public void displayRecord() {
        System.out.printf("  Record %-6s | Book: %-25s | Borrowed: %s | Due: %s",
            recordId, bookTitle, borrowDate, dueDate);
        if (returned) {
            System.out.printf(" | Returned: %s | Fine: PHP %.2f%n", returnDate, fine);
        } else {
            double currentFine = computeCurrentFine();
            if (currentFine > 0)
                System.out.printf(" | ** OVERDUE - Fine: PHP %.2f **%n", currentFine);
            else
                System.out.println(" | Active");
        }
    }

    public double computeCurrentFine() {
        if (returned || !LocalDate.now().isAfter(dueDate)) return 0;
        return (LocalDate.now().toEpochDay() - dueDate.toEpochDay()) * Book.FINE_PER_DAY;
    }
}
