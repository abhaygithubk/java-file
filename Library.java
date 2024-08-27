import java.util.ArrayList;
import java.util.Scanner;

class Book {
     String title;
     String author;
     boolean isAvailable;

     Book(String title, String author) {
         this.title = title;
         this.author = author;
         this.isAvailable = true;
     }
 }

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void removeBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                books.remove(book);
                break;
            }
        }
    }

    void displayBooks() {
        for (Book book : books) {
            System.out.println("Title:" + book.title + ",Author:" + book.author + ",Available:" + book.isAvailable);
        }
    }

    void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title) && book.isAvailable) {
                book.isAvailable = false;
                System.out.println("Book borrowed successfully!");
                break;
            } else {
                System.out.println("Book not available!");
            }
        }
    }

    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title) && !book.isAvailable) {
                book.isAvailable = true;
                System.out.println("Book returned successfully!");
                break;
            } else {
                System.out.println("Book not found!");
            }
        }
    }
}class LibraryManagementSystem { public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner= new Scanner(System.in);
    while (true) {
        System.out.println("1. Add Book");
        System.out.println("2.Remove Book");
        System.out.println("3. Display Books");
        System.out.println("4.Borrow Book");
        System.out.println("5.Return Book");
        System.out.println("6.Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        //Consume newline left-over
        switch (choice) {
            case 1:
                System.out.println("Enter book title:");
                String title = scanner.nextLine();
                System.out.println("Enter book author");
                String author= scanner.nextLine();
                library.addBook(new Book(title,author));
                break;
            case 2:
                System.out.println("Enter book title:");
                title= scanner.nextLine();
                library.removeBook(title);
                break;
            case 3:
                library.displayBooks();
                 break;
            case 4:
                System.out.println("Enter book title:");
                title=scanner.nextLine();
                library.borrowBook(title);
                break;
            case 5:
                System.out.println("Enter book title:");
                title = scanner.nextLine();
                library.returnBook(title);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid choice");

        }


    }
}

}
