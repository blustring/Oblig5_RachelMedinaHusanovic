package model;

import java.util.Date;

public class Crocodile extends Reptiles {
    private int numberOfTeeth;

    public Crocodile(boolean isVennon, int numberOfTeeth) {
        super(isVennon);
        this.numberOfTeeth = numberOfTeeth;
    }

    public Crocodile(int id, String name, String gender, String colour, Date dateOfBirth, Date dateOfArrival, int exhibitionNumb, boolean isVennon, int numberOfTeeth) {
        super(id, name, gender, colour, dateOfBirth, dateOfArrival, exhibitionNumb, isVennon);
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }
}
