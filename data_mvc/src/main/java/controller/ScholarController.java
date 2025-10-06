package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Author;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScholarController {

    private static final String API_KEY = "d65137a57c3fa3ca707fecec4cca7de398f6d4deb73d9d92fbe0e8c52a114513";
    private static final String API_URL = "https://serpapi.com/search.json?engine=google_scholar_profiles&q=";

    public List<Author> searchAuthors(String query) {
        List<Author> authors = new ArrayList<>();

        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            URL url = new URL(API_URL + encodedQuery + "&api_key=" + API_KEY);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.err.println("❌ Error en la conexión. Código HTTP: " + responseCode);
                return authors;
            }

            // Leer respuesta JSON
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Parsear respuesta con Gson
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray profiles = jsonResponse.getAsJsonArray("profiles");

            if (profiles == null || profiles.isEmpty()) {
                System.out.println("⚠️ No se encontraron autores con ese nombre.");
                return authors;
            }

            for (JsonElement profileElem : profiles) {
                JsonObject profile = profileElem.getAsJsonObject();

                String name = profile.has("name") ? profile.get("name").getAsString() : "Desconocido";
                String affiliation = profile.has("affiliations") ? profile.get("affiliations").getAsString() : "N/A";
                int citedBy = 0;

                if (profile.has("cited_by")) {
                    JsonObject citedByObj = profile.getAsJsonObject("cited_by");
                    if (citedByObj.has("value")) {
                        citedBy = citedByObj.get("value").getAsInt();
                    }
                }

                authors.add(new Author(name, affiliation, citedBy));
            }

        } catch (IOException e) {
            System.err.println("🚨 Error al conectar con la API: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("🚨 Error al procesar la respuesta: " + e.getMessage());
        }

        return authors;
    }
}
