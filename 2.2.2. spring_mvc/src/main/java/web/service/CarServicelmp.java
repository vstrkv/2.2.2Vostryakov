package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServicelmp implements CarService{
    private final CarDao carDao;

    public CarServicelmp(CarDao carDao) {
        this.carDao = carDao;
    }
    @Override
    public List<Car> getAllCars(Long count) {
        return carDao.getAllCars().stream().limit(count)
                .collect(Collectors.toList());
    }

}
