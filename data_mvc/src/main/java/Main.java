import controller.ScholarController;
import database.DatabaseManager;
import model.Author;
import view.ScholarView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main entry point for the Scholar project.
 */
public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.initializeDatabase();

        ScholarView view = new ScholarView();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.print("\n*few for testing purposes*\n" +
                    "OQpf9YsAAAAJ\n" +
                    "-dVjqTEAAAAJ\n" +
                    "JicYPdAAAAAJ\n" +
                    "q2YXPSgAAAAJ\n\n" +
                    "Enter the Author ID: ");
            String authorId = scanner.nextLine().trim();

            Author author = new Author("Unknown", "N/A", new ArrayList<>());
            ScholarController controller = new ScholarController(author, view);

            System.out.println("\nFetching author data...");
            controller.fetchAuthorData(authorId);

            // Save only the first 3 articles
            var articles = author.getArticles().subList(0, Math.min(3, author.getArticles().size()));
            dbManager.saveArticles(author.getName(), articles);
        }

        dbManager.displayAllArticles();
        scanner.close();
    }
}
