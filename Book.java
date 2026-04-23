class Book {
    int id;
    String title;
    String author;
    boolean isIssued;
    int issuedTo; // userId (-1 if not issued)

    public Book(int id, String title, String author, boolean isIssued, int issuedTo) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
        this.issuedTo = issuedTo;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + isIssued + "," + issuedTo;
    }
}