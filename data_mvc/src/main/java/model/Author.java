package model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String affiliation;
    private int hIndex;
    private List<Article> articles;

    public Author(String name, String affiliation, int hIndex, List articles){
        this.name = name;
        this.affiliation = affiliation;
        this.hIndex = hIndex;
        this.articles = articles;
    }

    public Author(String name, String affiliation, int hIndex) {
        this.name = name;
        this.affiliation = affiliation;
        this.hIndex = hIndex;
        this.articles = new ArrayList<>(); // inicializa vacío
    }


    //getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAffiliation() { return  affiliation; }
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public int getHIndex() {
        return hIndex;
    }

    public void setHIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
