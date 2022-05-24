package model;

import java.util.Date;

public class Elephant extends Mammals{
    private double weight;
    private double height;

    public Elephant(boolean furry, double weight, double height) {
        super(furry);
        this.weight = weight;
        this.height = height;
    }

    public Elephant(int id, String name, String gender, String colour, Date dateOfBirth, Date dateOfArrival, int exhibitionNumb, boolean furry, double weight, double height) {
        super(id, name, gender, colour, dateOfBirth, dateOfArrival, exhibitionNumb, furry);
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
