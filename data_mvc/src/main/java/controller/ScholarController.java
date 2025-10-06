package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Article;
import model.Author;
import view.ScholarView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class that fetches author data from Google Scholar via SerpApi
 * and updates the model and view.
 */
public class ScholarController {
    private Author model;
    private ScholarView view;
    private final String apiKey = "d65137a57c3fa3ca707fecec4cca7de398f6d4deb73d9d92fbe0e8c52a114513"; // Replace with your real SerpApi key

    public ScholarController(Author model, ScholarView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Fetches author data from SerpApi and updates the model and view.
     *
     * @param authorId Google Scholar Author ID.
     */
    public void fetchAuthorData(String authorId) {
        try {
            String url = "https://serpapi.com/search?engine=google_scholar_author&author_id="
                    + authorId + "&api_key=" + apiKey;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response.body());

            // ----------- Author data -----------
            model.setName(node.path("author").path("name").asText("Unknown"));
            model.setAffiliation(node.path("author").path("affiliations").asText("No affiliation"));

            // ----------- Articles -----------
            List<Article> articles = new ArrayList<>();
            JsonNode articlesNode = node.path("articles");

            if (articlesNode.isArray()) {
                for (JsonNode articleNode : articlesNode) {
                    String title = articleNode.path("title").asText("Untitled");
                    String authors = articleNode.path("authors").asText("Unknown authors");
                    String publicationDate = articleNode.path("year").asText("N/A");
                    String link = articleNode.path("link").asText("");

                    Article article = new Article(
                            title, authors, publicationDate, "", link, "", 0 // abstract, keywords, citedBy removed
                    );
                    articles.add(article);
                }
            }

            model.setArticles(articles);

            // ----------- Display on view -----------
            view.displayAuthor(model);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}
