package model;

import java.util.List;

/**
 * Represents an author from Google Scholar.
 */
public class Author {
    private String name;
    private String affiliation;
    private List<Article> articles;

    /**
     * Constructs a new Author object.
     *
     * @param name        Author's name.
     * @param affiliation Author's institutional affiliation.
     * @param articles    List of published articles.
     */
    public Author(String name, String affiliation, List<Article> articles) {
        this.name = name;
        this.affiliation = affiliation;
        this.articles = articles;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAffiliation() { return affiliation; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }

    public List<Article> getArticles() { return articles; }
    public void setArticles(List<Article> articles) { this.articles = articles; }
}
