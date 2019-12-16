package org.acme.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.acme.Car;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarRepository implements PanacheMongoRepository<Car> {
}
