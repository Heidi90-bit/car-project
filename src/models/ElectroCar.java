package models;

public class ElectroCar extends Car{
    int batteryCapacity;
    public ElectroCar(Integer id, int year, int horsePower, String brand,int batteryCapacity,boolean move) {
        super(id, year, horsePower, brand, move);
        this.batteryCapacity = batteryCapacity;
    }


    public void stop() {System.out.println(brand + " Остановка");}

    @Override
    public void drive(){
        System.out.println(brand + " едет с мощностью " + horsePower + " л.с.");
        System.out.println("Автобобиль " + brand+ "Заряжен на " + batteryCapacity + "%");
    }

}

