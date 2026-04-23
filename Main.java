import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        List<Book> books = LibraryService.loadBooks();
        List<User> users = LibraryService.loadUsers();

        while (true) {
            System.out.println("\n1.Add User");
            System.out.println("2.Add Book");
            System.out.println("3.Issue Book");
            System.out.println("4.Return Book");
            System.out.println("5.View Books");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    User u = new User(uid, name);
                    LibraryService.addUser(u);
                    users.add(u);
                    break;

                case 2:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    Book b = new Book(bid, title, author, false, -1);
                    LibraryService.addBook(b);
                    books.add(b);
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int bId = sc.nextInt();

                    System.out.print("User ID: ");
                    int uId = sc.nextInt();

                    LibraryService.issueBook(bId, uId, books);
                    LibraryService.saveBooks(books);
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    int rId = sc.nextInt();

                    LibraryService.returnBook(rId, books);
                    LibraryService.saveBooks(books);
                    break;

                case 5:
                    for (Book book : books) {
                        System.out.println(
                            book.id + " | " +
                            book.title + " | " +
                            (book.isIssued ? "Issued to " + book.issuedTo : "Available")
                        );
                    }
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}