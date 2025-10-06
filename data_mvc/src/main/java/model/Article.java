package model;

/**
 * Represents an academic article in Google Scholar.
 */
public class Article {
    private String title;
    private String authors;
    private String publicationDate;
    private String abstractText;
    private String link;
    private String keywords;
    private int citedBy;

    /**
     * Constructs a new Article object.
     *
     * @param title           Title of the article.
     * @param authors         Authors of the article.
     * @param publicationDate Publication date or year.
     * @param abstractText    Abstract or summary of the article.
     * @param link            Link to the article on Google Scholar.
     * @param keywords        Keywords associated with the article.
     * @param citedBy         Number of citations.
     */
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

    // Getters and Setters

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }

    public void setAuthors(String authors) { this.authors = authors; }

    public String getPublicationDate() { return publicationDate; }

    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }

    public String getAbstractText() { return abstractText; }

    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public String getKeywords() { return keywords; }

    public void setKeywords(String keywords) { this.keywords = keywords; }

    public int getCitedBy() { return citedBy; }

    public void setCitedBy(int citedBy) { this.citedBy = citedBy; }
}
