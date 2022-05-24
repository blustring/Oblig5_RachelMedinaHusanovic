package model;

import java.util.Date;

public abstract class Animal {
    protected int id;
    protected String name;
    protected String gender;
    protected String colour;
    protected Date dateOfBirth;
    protected Date dateOfArrival;
    protected int exhibitionNumb;

    public Animal() {
    }

    public Animal(int id, String name, String gender, String colour, Date dateOfBirth, Date dateOfArrival, int exhibitionNumb) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.colour = colour;
        this.dateOfBirth = dateOfBirth;
        this.dateOfArrival = dateOfArrival;
        this.exhibitionNumb = exhibitionNumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getExhibitionNumb() {
        return exhibitionNumb;
    }

    public void setExhibitionNumb(int exhibitionNumb) {
        this.exhibitionNumb = exhibitionNumb;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
