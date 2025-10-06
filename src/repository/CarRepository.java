package repository;

import models.Car;
import java.util.*;

public class CarRepository implements Repository<Car, Integer> {
    private Map<Integer, Car> cars = new HashMap<>();
    private int nextId = 1;


    @Override
    public Car save(Car car) {
        if (car == null) {
            System.out.println("Ошибка: нельзя сохранить null");
            return null;
        }

        if (car.getId() == null) {
            car.setId(nextId);
            cars.put(nextId, car);
            System.out.println("Сохранили машину: " + car.brand + " (ID: " + nextId + ")");
            nextId++;
        } else {
            cars.put(car.getId(), car);
            System.out.println("Обновили машину: " + car.brand + " (ID: " + car.getId() + ")");
        }

        return car;
    }


    @Override
    public List<Car> saveAll(Collection<Car> entities) {
        List<Car> savedCars = new ArrayList<>();
        System.out.println("Сохраняем коллекцию машин...");

        for (Car car : entities) {
            Car savedCar = save(car);
            if (savedCar != null) {
                savedCars.add(savedCar);
            }
        }

        System.out.println("Сохранено машин: " + savedCars.size());
        return savedCars;
    }


    @Override
    public Optional<Car> findById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return Optional.empty();
        }

        Car car = cars.get(id);
        if (car != null) {
            System.out.println("Нашли машину с ID " + id + ": " + car.brand);
        } else {
            System.out.println("Не нашли машину с ID " + id);
        }

        return Optional.ofNullable(car);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            System.out.println(" ID не может быть null");
            return;
        }

        Car removedCar = cars.remove(id);
        if (removedCar != null) {
            System.out.println("Удалили машину с ID " + id + ": " + removedCar.brand);
        } else {
            System.out.println("Машина с ID " + id + " не найдена");
        }
    }

    @Override
    public void deleteAll() {
        int carCount = cars.size();
        cars.clear();
        nextId = 1;
        System.out.println("Удалили ВСЕ машины. Было удалено: " + carCount + " машин");
    }

    @Override
    public long count() {
        long carCount = cars.size();
        System.out.println("Всего машин в репозитории: " + carCount);
        return carCount;
    }

    @Override
    public boolean existsById(Integer id) {
        if (id == null) {
            return false;
        }

        boolean exists = cars.containsKey(id);
        System.out.println("Машина с ID " + id + " существует: " + exists);
        return exists;
    }
}