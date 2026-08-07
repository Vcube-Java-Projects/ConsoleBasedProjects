package oopsLibrary;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nStatus: " + (issued ? "Issued" : "Available");
    }
}
import java.util.ArrayList;

public class LibraryService {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books Available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
            System.out.println("----------------------");
        }
    }

    public void searchBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println("Book Issued Successfully.");
                } else {
                    System.out.println("Book Already Issued.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                if (book.isIssued()) {
                    book.setIssued(false);
                    System.out.println("Book Returned Successfully.");
                } else {
                    System.out.println("Book is Already Available.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    public void deleteBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                books.remove(book);
                System.out.println("Book Deleted Successfully.");
                return;
            }
        }
        System.out.println("Book Not Found.");
    }
}
import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {

            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    service.addBook(new Book(id, title, author));
                    break;

                case 2:
                    service.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    service.searchBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    service.issueBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    service.returnBook(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    service.deleteBook(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
