package models;

public class Sedan extends Car {
    int passCount;
    public Sedan(Integer id, int year, int horsePower, String brand, int passCount, boolean move) {
        super(id, year, horsePower, brand, move);
        this.passCount = passCount;
        this.move = move;
    }
     public void drive() {System.out.println(brand + " Едет");}
     public void stop() {System.out.println(brand + " Остановка");}
}