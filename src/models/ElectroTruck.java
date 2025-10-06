package models;
import interfaces.Truckable;

public class ElectroTruck extends ElectroCar implements Truckable {
    int currentCapacity;

    public ElectroTruck(Integer id, int year, int horsePower, String brand, int batteryCapacity, boolean move, int Capacity) {
        super(id, year, horsePower, brand, batteryCapacity, move);
      this.currentCapacity=Capacity;
    }
    public void load(){
        System.out.println("Загружаем электогрузовик " + brand+ ", базовая вместимость: " +Capacity + ", Текущая: " + currentCapacity + ", максимальная: " + maxCapacity);
    }
}