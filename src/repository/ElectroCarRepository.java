package repository;

import models.ElectroCar;
import java.util.*;

public class ElectroCarRepository implements Repository<ElectroCar, Integer> {
    private Map<Integer, ElectroCar> electroCars = new HashMap<>();
    private int nextId = 1;


    @Override
    public ElectroCar save(ElectroCar electroCar) {
        if (electroCar == null) {
            System.out.println("Ошибка: нельзя сохранить null");
            return null;
        }

        if (electroCar.getId() == null) {
            electroCar.setId(nextId);
            electroCars.put(nextId, electroCar);
            System.out.println("⚡ Сохранили электромобиль: " + electroCar.brand + " (ID: " + nextId + ")");
            nextId++;
        } else {
            electroCars.put(electroCar.getId(), electroCar);
            System.out.println("⚡ Обновили электромобиль: " + electroCar.brand + " (ID: " + electroCar.getId() + ")");
        }

        return electroCar;
    }


    @Override
    public List<ElectroCar> saveAll(Collection<ElectroCar> entities) {
        List<ElectroCar> savedCars = new ArrayList<>();
        System.out.println("Сохраняем коллекцию электромобилей...");

        for (ElectroCar electroCar : entities) {
            ElectroCar savedCar = save(electroCar);
            if (savedCar != null) {
                savedCars.add(savedCar);
            }
        }

        System.out.println("⚡ Сохранено электромобилей: " + savedCars.size());
        return savedCars;
    }

    @Override
    public Optional<ElectroCar> findById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return Optional.empty();
        }

        ElectroCar electroCar = electroCars.get(id);
        if (electroCar != null) {
            System.out.println("Нашли электромобиль с ID " + id + ": " + electroCar.brand);
        } else {
            System.out.println("Не нашли электромобиль с ID " + id);
        }

        return Optional.ofNullable(electroCar);
    }


    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            System.out.println("ID не может быть null");
            return;
        }

        ElectroCar removedCar = electroCars.remove(id);
        if (removedCar != null) {
            System.out.println("Удалили электромобиль с ID " + id + ": " + removedCar.brand);
        } else {
            System.out.println("Электромобиль с ID " + id + " не найден");
        }
    }


    @Override
    public void deleteAll() {
        int carCount = electroCars.size();
        electroCars.clear();
        nextId = 1;
        System.out.println("Удалили ВСЕ электромобили. Было удалено: " + carCount + " машин");
    }


    @Override
    public long count() {
        long carCount = electroCars.size();
        System.out.println("Всего электромобилей в репозитории: " + carCount);
        return carCount;
    }


    @Override
    public boolean existsById(Integer id) {
        if (id == null) {
            return false;
        }

        boolean exists = electroCars.containsKey(id);
        System.out.println("Электромобиль с ID " + id + " существует: " + exists);
        return exists;
    }
}