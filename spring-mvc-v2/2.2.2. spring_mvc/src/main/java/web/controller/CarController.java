package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") Long count, ModelMap model) {

        Car car_1 = new Car("brand_1", "model_1", 2020);
        Car car_2 = new Car("brand_2", "model_2", 2019);
        Car car_3 = new Car("brand_3", "model_3", 2018);
        Car car_4 = new Car("brand_4", "model_4", 2017);
        Car car_5 = new Car("brand_5", "model_5", 2015);

        List<Car> list = new ArrayList<>();

        list.add(car_1);
        list.add(car_2);
        list.add(car_3);
        list.add(car_4);
        list.add(car_5);

        List<Car> sortedList = list.stream()
                .limit(count)
                .collect(Collectors.toList());

        model.addAttribute("car", sortedList);

        return "cars";
    }
}
