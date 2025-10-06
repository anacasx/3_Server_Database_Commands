package view;

import model.Article;
import model.Author;

/**
 * View class responsible for displaying author information in the console.
 */
public class ScholarView {

    /**
     * Displays an author's information and their articles in the console.
     *
     * @param author The Author object containing the data to display.
     */
    public void displayAuthor(Author author) {
        System.out.println("Author: " + author.getName());
        System.out.println("Affiliation: " + author.getAffiliation());
        System.out.println("Articles:");
        for (Article article : author.getArticles()) {
            System.out.println("- " + article.getTitle() + " (" + article.getPublicationDate() + ")");
        }
    }
}
