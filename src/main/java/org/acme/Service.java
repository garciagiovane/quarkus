package org.acme;

import org.acme.properties.PropertySource;
import org.acme.repository.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class Service {

    @Inject
    CarRepository carRepository;

    private PropertySource propertySource;

    public Service(PropertySource propertySource) {
        this.propertySource = propertySource;
    }

    public String hello() {
        return propertySource.helloMessage();
    }

    public List<String> getListFromProperties() {
        return propertySource.listFromProperties();
    }

    public Integer getFromPropertyUnnamed() {
        return propertySource.getInteger();
    }

    public String getString() {
        return propertySource.getString();
    }

    public List<Car> getCars() {
        return carRepository.listAll();
    }

    public Car saveCar(Car car) {
        carRepository.persist(car);
        return car;
    }

    public List<Car> getCarsFiltered(String color) {
        return carRepository.list("color like ?1", color);
    }
}
