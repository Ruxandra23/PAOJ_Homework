package exercitiul1;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.setPageCount(pageCount);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Numărul de pagini trebuie să fie diferit de zero.");
        }
        this.pageCount = pageCount;
    }

    public void displayInfo() {
        System.out.println("BOOK_TITLE: " + title.toUpperCase());
        System.out.println("BOOK_AUTHOR: " + author);
        System.out.println("BOOK_PUBLISHER: " + publisher.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return this.title.equals(other.title) &&
                this.author.equals(other.author) &&
                this.publisher.equals(other.publisher) &&
                this.pageCount == other.pageCount;
    }
}
