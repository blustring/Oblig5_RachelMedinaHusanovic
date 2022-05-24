package Controller;

import model.Crocodile;
import model.Elephant;

import java.util.ArrayList;

public class AnimalController {

    ArrayList<Elephant> elephants;
    ArrayList<Crocodile> crocodiles;

    public AnimalController() {
        elephants = new ArrayList<>();
        crocodiles = new ArrayList<>();
    }

    public ArrayList<Elephant> getElephants() {
        return elephants;
    }

    public void setElephants(ArrayList<Elephant> elephants) {
        this.elephants = elephants;
    }

    public ArrayList<Crocodile> getCrocodiles() {
        return crocodiles;
    }

    public void setCrocodiles(ArrayList<Crocodile> crocodiles) {
        this.crocodiles = crocodiles;
    }

    public void printElephants() {

        for (int i = 0; i < elephants.size(); i++) {
            System.out.println("ID: " + elephants.get(i).getId());
            System.out.println("Name: " + elephants.get(i).getName());
            System.out.println("Gender: " + elephants.get(i).getGender());
            System.out.println("Weight: " + elephants.get(i).getWeight());


        }
    }

    public void printCrocodile() {

        for (int i = 0; i < crocodiles.size(); i++) {
            System.out.println("ID: " + crocodiles.get(i).getId());
            System.out.println("Name: " + crocodiles.get(i).getName());
            System.out.println("Gender: " + crocodiles.get(i).getGender());
            System.out.println("Teeth: " + crocodiles.get(i).getNumberOfTeeth());


        }
    }
}
