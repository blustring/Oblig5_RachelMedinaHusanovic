package model;

import java.util.Date;

public class Reptiles extends Animal{
    protected boolean isVennon;

    public Reptiles(boolean isVennon) {
        this.isVennon = isVennon;
    }

    public Reptiles(int id, String name, String gender, String colour, Date dateOfBirth, Date dateOfArrival, int exhibitionNumb, boolean isVennon) {
        super(id, name, gender, colour, dateOfBirth, dateOfArrival, exhibitionNumb);
        this.isVennon = isVennon;
    }

    public boolean getIsVennon() {
            return isVennon;
        }

        public void setIsVennon(boolean isVennon) {
            this.isVennon = isVennon;
        }



}
