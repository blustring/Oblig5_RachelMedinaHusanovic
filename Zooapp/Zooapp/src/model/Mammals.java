package model;

import java.util.Date;

public class Mammals extends Animal{
    protected boolean furry;

    public Mammals(boolean furry) {
        this.furry = furry;
    }

    public Mammals(int id, String name, String gender, String colour, Date dateOfBirth, Date dateOfArrival, int exhibitionNumb, boolean furry) {
        super(id, name, gender, colour, dateOfBirth, dateOfArrival, exhibitionNumb);
        this.furry = furry;
    }

    public boolean isFurry() {
        return furry;
    }

    public void setFurry(boolean furry) {
        this.furry = furry;
    }
}
