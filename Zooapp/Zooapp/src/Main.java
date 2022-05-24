import Controller.AnimalController;
import View.Dashboard;
import model.Crocodile;
import model.Elephant;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        AnimalController animalController = new AnimalController();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Date date = new Date();

        Elephant elephant = new Elephant(12, "Elephant1", "Male", "White", date,
                date, 1, true, 343, 343);
        animalController.getElephants().add(elephant);

        Crocodile crocodile = new Crocodile(12, "Croco2", "Male", "White", date,
                date, 1, true, 23);

        animalController.getCrocodiles().add(crocodile);

        Crocodile crocodile1 = new Crocodile(13, "Croco", "Female", "White", date,
                date, 1, true, 23);

        animalController.getCrocodiles().add(crocodile1);

        Dashboard db = new Dashboard(animalController);


    }
}
