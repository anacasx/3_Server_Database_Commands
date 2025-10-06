package view;

import model.Author;
import java.util.List;

public class ScholarView {

    public void showResults(List<Author> authors) {
        if (authors.isEmpty()) {
            System.out.println("❌ No se encontró ningún autor con ese nombre.");
        } else {
            System.out.println("\n=== RESULTADOS DE LA BÚSQUEDA ===");
            for (Author author : authors) {
                System.out.println(author);
            }
        }
    }

    public void showError(String message) {
        System.err.println("⚠️ " + message);
    }
}
