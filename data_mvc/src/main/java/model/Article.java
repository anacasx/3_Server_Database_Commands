package model;

/**
 * Represents a research article retrieved from Google Scholar.
 */
public class Article {
    private String title;
    private String authors;
    private String publicationDate;
    private String abstractText;
    private String link;
    private String keywords;
    private int citedBy;

    public Article(String title, String authors, String publicationDate, String abstractText,
                   String link, String keywords, int citedBy) {
        this.title = title;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.abstractText = abstractText;
        this.link = link;
        this.keywords = keywords;
        this.citedBy = citedBy;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthors() { return authors; }
    public String getPublicationDate() { return publicationDate; }
    public String getAbstractText() { return abstractText; }
    public String getLink() { return link; }
    public String getKeywords() { return keywords; }
    public int getCitedBy() { return citedBy; }
}
