package models;

public enum CarBrand {
    TOYOTA,
    VOLVO,
    TESLA,
    PORSCHE,
    BMW;


    public String getBrandName() {

        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}