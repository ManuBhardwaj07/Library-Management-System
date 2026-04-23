import java.io.*;
import java.util.*;

class LibraryService {

    static final String BOOK_FILE = "books.txt";
    static final String USER_FILE = "users.txt";

    // ---------------- BOOK ----------------

    public static List<Book> loadBooks() throws Exception {
        List<Book> list = new ArrayList<>();
        File file = new File(BOOK_FILE);

        if (!file.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Book(
                Integer.parseInt(d[0]),
                d[1],
                d[2],
                Boolean.parseBoolean(d[3]),
                Integer.parseInt(d[4])
            ));
        }
        br.close();
        return list;
    }

    public static void saveBooks(List<Book> books) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE));
        for (Book b : books) {
            bw.write(b.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static void addBook(Book b) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE, true));
        bw.write(b.toString());
        bw.newLine();
        bw.close();
    }

    // ---------------- USER ----------------

    public static List<User> loadUsers() throws Exception {
        List<User> list = new ArrayList<>();
        File file = new File(USER_FILE);

        if (!file.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new User(
                Integer.parseInt(d[0]),
                d[1]
            ));
        }
        br.close();
        return list;
    }

    public static void addUser(User u) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true));
        bw.write(u.toString());
        bw.newLine();
        bw.close();
    }

    // ---------------- ISSUE / RETURN ----------------

    public static void issueBook(int bookId, int userId, List<Book> books) {
        for (Book b : books) {
            if (b.id == bookId && !b.isIssued) {
                b.isIssued = true;
                b.issuedTo = userId;
                System.out.println("Book issued to User " + userId);
                return;
            }
        }
        System.out.println("Book not available");
    }

    public static void returnBook(int bookId, List<Book> books) {
        for (Book b : books) {
            if (b.id == bookId && b.isIssued) {
                b.isIssued = false;
                b.issuedTo = -1;
                System.out.println("Book returned");
                return;
            }
        }
        System.out.println("Invalid return");
    }
}