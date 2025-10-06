package models;
import interfaces.Truckable;
import repository.CarRepository;

public class Main {
    public static void main(String[] args) {
        Sedan sedan_0 = new Sedan(2020, 300, "Порше ", 5000,false);
        sedan_0.drive();

        Truck truck = new Truck(2020, 300, "Volvo ", 5000, false);
        truck.drive();
        truck.stop();


//        Sedan[] sedans = new Sedan[]{sedan_0, sedan_1};
//
//        for (int i = 0; i < sedans.length; i++) {
//            sedans[i].drive();
//        }



        ElectroCar electro = new ElectroCar(2020, 300, "Tesla ", 5000, true);
        electro.stop();
        electro.drive();


        Truckable TruckInterface = new Truck(2020, 300, "Volvo ", 450, false);
        TruckInterface.load();

        Truckable electroTruckInterface = new ElectroTruck(2021, 400, "TeslaСybertruck ", 300, true, 100);
        electroTruckInterface.load();



        System.out.println("-----------------------------------------------");

        CarRepository repo = new CarRepository();
        Sedan s1 = new Sedan(2020, 300, "Toyota", 5, false);
        Sedan s2 = new Sedan(2021, 350, "Tesla", 4, true);
        Sedan s3 = new Sedan(2020, 300, "Porsche", 5, false);
        Truck t1 = new Truck(2020, 400, "Volvo", 5000, false);

        repo.addCar(s1);
        repo.addCar(s2);
        repo.addCar(s3);
        repo.addCar(t1);

//        repo.getCar("Toyota");
//        repo.getCar("BMW");
//
//        repo.delCar(1);

        repo.getCars(CarBrand.TOYOTA);
        repo.getCars(CarBrand.VOLVO);
        repo.getCars(CarBrand.TESLA);
        repo.getCars(CarBrand.PORSCHE);
        repo.getCars(CarBrand.BMW);
        
    }
}
