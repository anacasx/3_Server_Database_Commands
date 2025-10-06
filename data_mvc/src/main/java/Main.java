import controller.ScholarController;
import model.Author;
import view.ScholarView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main entry point of the program.
 */
public class Main {
    public static void main(String[] args) {
        Author author = new Author("Unknown", "N/A", new ArrayList<>());
        ScholarView view = new ScholarView();
        ScholarController controller = new ScholarController(author, view);

        Scanner scanner = new Scanner(System.in);
        String authorId = "";

        do {
            System.out.print("\n*few for testing purposes*\n" +
                    "OQpf9YsAAAAJ\n" +
                    "-dVjqTEAAAAJ\n" +
                    "JicYPdAAAAAJ\n" +
                    "q2YXPSgAAAAJ\n\n" +
                    "Enter the Author ID: ");
            authorId = scanner.nextLine().trim();

            if (authorId.isEmpty()) {
                System.out.println("Author ID cannot be empty. Please try again.");
            }
        } while (authorId.isEmpty());

        System.out.println("\nFetching author data...");
        controller.fetchAuthorData(authorId);

        scanner.close();
    }
}
