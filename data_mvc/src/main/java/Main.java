import controller.ScholarController;
import model.Author;
import view.ScholarView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScholarController controller = new ScholarController();
        ScholarView view = new ScholarView();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del autor: ");
        String name = scanner.nextLine();

        List<Author> results = controller.searchAuthors(name);
        view.showResults(results);
    }
}
