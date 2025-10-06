package models;

public abstract class Car {
    protected Integer id;
    int year;
    int horsePower;
    public String brand;
    boolean move;

    public Car(Integer id, int year, int horsePower, String brand, boolean move) {
        this.id=id;
        this.year = year;
        this.horsePower = horsePower;
        this.brand = brand;
        this.move = move;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    abstract void drive();
    abstract void stop();


    }
