package oop;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    private String borrowedBy;       
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public static final int BORROW_DAYS = 7;
    public static final double FINE_PER_DAY = 5.0; 

    public Book(String bookId, String title, String author, String genre) {
        this.bookId      = bookId;
        this.title       = title;
        this.author      = author;
        this.genre       = genre;
        this.isAvailable = true;
        this.borrowedBy  = null;
    }

  
    public String getBookId()      { return bookId; }
    public String getTitle()       { return title; }
    public String getAuthor()      { return author; }
    public String getGenre()       { return genre; }
    public boolean isAvailable()   { return isAvailable; }
    public String getBorrowedBy()  { return borrowedBy; }
    public LocalDate getBorrowDate(){ return borrowDate; }
    public LocalDate getDueDate()  { return dueDate; }

   
    public void borrowBook(String memberId) {
        isAvailable = false;
        borrowedBy  = memberId;
        borrowDate  = LocalDate.now();
        dueDate     = borrowDate.plusDays(BORROW_DAYS);
    }

    public void returnBook() {
        isAvailable = true;
        borrowedBy  = null;
        borrowDate  = null;
        dueDate     = null;
    }

    public double computeFine() {
        if (dueDate == null || !LocalDate.now().isAfter(dueDate)) return 0;
        long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
        return overdueDays * FINE_PER_DAY;
    }

    public void displayInfo() {
        System.out.println("  Book ID : " + bookId);
        System.out.println("  Title   : " + title);
        System.out.println("  Author  : " + author);
        System.out.println("  Genre   : " + genre);
        System.out.println("  Status  : " + (isAvailable ? "Available" : "Borrowed by " + borrowedBy));
        if (!isAvailable) {
            System.out.println("  Due Date: " + dueDate);
        }
        System.out.println("  " + "-".repeat(38));
    }
}
