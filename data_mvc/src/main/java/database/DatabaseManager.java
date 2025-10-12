package database;

import model.Article;

import java.sql.*;
import java.util.List;

/**
 * Handles all database operations related to articles.
 */
public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:scholar.db";

    /**
     * Creates the articles table if it does not exist.
     */
    public void initializeDatabase() {
        String sql = """
                CREATE TABLE IF NOT EXISTS articles (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT,
                    authors TEXT,
                    publication_date TEXT,
                    abstract TEXT,
                    link TEXT,
                    keywords TEXT,
                    cited_by INTEGER,
                    researcher_name TEXT
                );
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Database and table ready.");
        } catch (SQLException e) {
            System.err.println("❌ Database initialization error: " + e.getMessage());
        }
    }

    /**
     * Inserts a list of articles into the database.
     *
     * @param researcherName The name of the researcher.
     * @param articles       The list of articles to store.
     */
    public void saveArticles(String researcherName, List<Article> articles) {
        String sql = """
                INSERT INTO articles (title, authors, publication_date, abstract, link, keywords, cited_by, researcher_name)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Article article : articles) {
                pstmt.setString(1, article.getTitle());
                pstmt.setString(2, article.getAuthors());
                pstmt.setString(3, article.getPublicationDate());
                pstmt.setString(4, article.getAbstractText());
                pstmt.setString(5, article.getLink());
                pstmt.setString(6, article.getKeywords());
                pstmt.setInt(7, article.getCitedBy());
                pstmt.setString(8, researcherName);
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            System.out.println("💾 Articles successfully saved for " + researcherName);

        } catch (SQLException e) {
            System.err.println("❌ Error saving articles: " + e.getMessage());
        }
    }

    /**
     * Displays all stored articles.
     */
    public void displayAllArticles() {
        String sql = "SELECT * FROM articles;";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== Stored Articles ===");
            while (rs.next()) {
                System.out.println("- " + rs.getString("title") + " | Researcher: " + rs.getString("researcher_name"));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving articles: " + e.getMessage());
        }
    }
}
