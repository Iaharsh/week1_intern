import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully: " + title);
        } else {
            System.out.println("This book is already issued!");
        }
    }
    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully: " + title);
        } else {
            System.out.println("This book was not issued.");
        }
    }
    public void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}
class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
    public void borrowBook(Book book) {
        if (!book.isIssued()) {
            book.issueBook();
            borrowedBooks.add(book);
        } else {
            System.out.println(" Sorry, this book is already borrowed by someone else.");
        }
    }
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("You don’t have this book to return.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("\n Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed yet.");
        } else {
            for (Book b : borrowedBooks) {
                System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book("Atomic Habits", "James Clear");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("The Alchemist", "Paulo Coelho");

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter member ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        Member member = new Member(name, id);

        int choice;
        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. View all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View borrowed books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Books:");
                    book1.displayBookInfo();
                    book2.displayBookInfo();
                    book3.displayBookInfo();
                    break;

                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = sc.nextLine();
                    if (borrowTitle.equalsIgnoreCase(book1.getTitle())) member.borrowBook(book1);
                    else if (borrowTitle.equalsIgnoreCase(book2.getTitle())) member.borrowBook(book2);
                    else if (borrowTitle.equalsIgnoreCase(book3.getTitle())) member.borrowBook(book3);
                    else System.out.println(" Book not found.");
                    break;

                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    if (returnTitle.equalsIgnoreCase(book1.getTitle())) member.returnBook(book1);
                    else if (returnTitle.equalsIgnoreCase(book2.getTitle())) member.returnBook(book2);
                    else if (returnTitle.equalsIgnoreCase(book3.getTitle())) member.returnBook(book3);
                    else System.out.println(" Book not found.");
                    break;

                case 4:
                    member.displayBorrowedBooks();
                    break;

                case 5:
                    System.out.println(" Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}


