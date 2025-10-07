package models;
import interfaces.Truckable;
import repository.CarRepository;
import repository.ElectroCarRepository;

public class Main {
    public static void main(String[] args) {
        Sedan sedan_0 = new Sedan(null,2020, 300, "Порше ", 5000,false);
        sedan_0.drive();

        Sedan sedan_1 = new Sedan(null,2020, 300, "Ламборгини ", 5000,false);
        sedan_1.drive();

        Truck truck = new Truck(null,2020, 300, "Volvo ", 5000, false);
        truck.drive();
        truck.stop();

//        Sedan[] sedans = new Sedan[]{sedan_0, sedan_1};
//        for (int i = 0; i < sedans.length; i++) {
//            sedans[i].drive();
//        }



        ElectroCar electro = new ElectroCar(null,2020, 300, "Tesla ", 300, true);
        electro.stop();
        electro.drive();

        Truckable TruckInterface = new Truck(null,2020, 300, "Volvo ", 450, false);
        TruckInterface.load();

        Truckable electroTruckInterface = new ElectroTruck(null,2021, 400, "TeslaСybertruck ", 300, true, 100);
        electroTruckInterface.load();

        System.out.println("-----------------------------------------------");


        System.out.println("====================задание на дом====================");

        CarRepository carRepo = new CarRepository();
        ElectroCarRepository electroRepo = new ElectroCarRepository();

        System.out.println("--- CarRepository ---");
        Sedan newSedan = new Sedan(null, 2022, 250, "Honda", 4, false);
        Truck newTruck = new Truck(null, 2021, 350, "Ford", 3000, false);

        carRepo.save(newSedan);
        carRepo.save(newTruck);

        System.out.println("--- ElectroCarRepository ---");
        ElectroCar newElectro = new ElectroCar(null, 2023, 400, "Tesla", 7000, true);
        ElectroCar newElectro2 = new ElectroCar(null, 2022, 350, "Nissan", 6000, false);

        electroRepo.save(newElectro);
        electroRepo.save(newElectro2);

        System.out.println("------");
        carRepo.findById(1);
        electroRepo.findById(1);

        System.out.println("------");
        carRepo.count();
        electroRepo.count();

        System.out.println("------");
        carRepo.deleteById(2);
        electroRepo.deleteById(1);
        electroRepo.count();

    }
}