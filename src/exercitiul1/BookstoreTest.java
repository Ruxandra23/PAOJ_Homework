package exercitiul1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookstoreTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n1. Adaugă carte");
            System.out.println("2. Afișează toate cărțile");
            System.out.println("3. Actualizează carte");
            System.out.println("4. Șterge carte");
            System.out.println("5. Verifica dublu exemplar");
            System.out.println("6. Verifica grosimea cartii");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> createBook();
                case 2 -> readBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> checkDuplicate();
                case 6 -> checkThicker();
                case 0 -> running = false;
                default -> System.out.println("Opțiune invalidă!");
            }
        }
    }

    private static void createBook() {
        try {
            System.out.print("Titlu: ");
            String title = scanner.nextLine();
            System.out.print("Autor: ");
            String author = scanner.nextLine();
            System.out.print("Editură: ");
            String publisher = scanner.nextLine();
            System.out.print("Număr pagini: ");
            int pages = Integer.parseInt(scanner.nextLine());

            Book book = new Book(title, author, publisher, pages);
            books.add(book);
            System.out.println("Carte adăugată cu succes!");
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }

    private static void readBooks() {
        if (books.isEmpty()) {
            System.out.println("Nu există cărți.");
        } else {
            int index = 1;
            for (Book b : books) {
                System.out.println("\nCarte #" + index++);
                b.displayInfo();
                System.out.println("Număr pagini: " + b.getPageCount());
            }
        }
    }

    private static void updateBook() {
        readBooks();
        System.out.print("Introduceți indexul cărții de modificat: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            System.out.print("Titlu nou: ");
            book.setTitle(scanner.nextLine());
            System.out.print("Autor nou: ");
            book.setAuthor(scanner.nextLine());
            System.out.print("Editură nouă: ");
            book.setPublisher(scanner.nextLine());
            System.out.print("Număr pagini nou: ");
            book.setPageCount(Integer.parseInt(scanner.nextLine()));
            System.out.println("Carte actualizată.");
        } else {
            System.out.println("Index invalid.");
        }
    }

    private static void deleteBook() {
        readBooks();
        System.out.print("Introduceți indexul cărții de șters: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < books.size()) {
            books.remove(index);
            System.out.println("Carte ștearsă.");
        } else {
            System.out.println("Index invalid.");
        }
    }

    private static void checkDuplicate() {
        if (books.size() < 2) {
            System.out.println("Adaugă cel puțin 2 cărți pentru comparație.");
            return;
        }

        System.out.print("Index prima carte: ");
        int i1 = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.print("Index a doua carte: ");
        int i2 = Integer.parseInt(scanner.nextLine()) - 1;

        if (validIndexes(i1, i2)) {
            boolean duplicate = isDuplicate(books.get(i1), books.get(i2));
            System.out.println(duplicate ? "Cărțile sunt duplicate." : "Cărțile sunt diferite.");
        } else {
            System.out.println("Index invalid.");
        }
    }

    private static void checkThicker() {
        if (books.size() < 2) {
            System.out.println("Adaugă cel puțin 2 cărți pentru comparație.");
            return;
        }

        System.out.print("Index prima carte: ");
        int i1 = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.print("Index a doua carte: ");
        int i2 = Integer.parseInt(scanner.nextLine()) - 1;

        if (validIndexes(i1, i2)) {
            Book thicker = thickerBook(books.get(i1), books.get(i2));
            System.out.println("Cartea mai groasă este:");
            thicker.displayInfo();
        } else {
            System.out.println("Index invalid.");
        }
    }

    private static boolean isDuplicate(Book b1, Book b2) {
        return b1.equals(b2);
    }

    private static Book thickerBook(Book b1, Book b2) {
        return (b1.getPageCount() > b2.getPageCount()) ? b1 : b2;
    }

    private static boolean validIndexes(int i1, int i2) {
        return i1 >= 0 && i2 >= 0 && i1 < books.size() && i2 < books.size();
    }
}
