import java.util.*;


class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}


class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

class Library {
    private List<Book> allBooks = new ArrayList<>(); // shelf of all books
    private Map<Integer, Integer> issuedBookRecords = new HashMap<>(); // bookId -> userId

    public void addBook(Book newBook) {
        allBooks.add(newBook);
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (allBooks.isEmpty()) {
            System.out.println("No books in the library yet!");
            return;
        }
        for (Book currentBook : allBooks) {
            System.out.println(currentBook);
        }
    }

    public void searchBook(String title) {
        for (Book currentBook : allBooks) {
            if (currentBook.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + currentBook);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void issueBook(int bookId, User user) {
        for (Book currentBook : allBooks) {
            if (currentBook.getId() == bookId && !currentBook.isIssued()) {
                currentBook.issueBook();
                issuedBookRecords.put(bookId, user.getId());
                System.out.println("Book issued to " + user.getName());
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(int bookId, User user) {
        if (issuedBookRecords.containsKey(bookId) && issuedBookRecords.get(bookId) == user.getId()) {
            for (Book currentBook : allBooks) {
                if (currentBook.getId() == bookId) {
                    currentBook.returnBook();
                    issuedBookRecords.remove(bookId);
                    System.out.println("Book returned successfully!");
                    return;
                }
            }
        }
        System.out.println("Invalid return!");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        
        User sampleUser = new User(1, "John");

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, sampleUser);
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId, sampleUser);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
