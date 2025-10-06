package controller;

import model.Author;
import org.junit.jupiter.api.Test;
import view.ScholarView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScholarControllerTest {

    @Test
    void testModelUpdate() {
        Author author = new Author("Test", "None", 0, new ArrayList<>());
        ScholarView view = new ScholarView();
        ScholarController controller = new ScholarController(author, view);

        // Simular actualización de datos
        author.setName("Ana Chang");
        author.setHIndex(10);

        assertEquals("Ana Chang", author.getName());
        assertEquals(10, author.getHIndex());
    }
}
