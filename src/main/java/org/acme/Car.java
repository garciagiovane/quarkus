package org.acme;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Car extends PanacheMongoEntity {

    @NotBlank(message = "Brand must not be blank")
    private String brand;
    @NotNull(message = "Color must not be blank")
    private String color;

    public static Car saveCar(Car car) {
        car.persist();
        return car;
    }

    public static List<Car> getAllCars() {
        return listAll();
    }

    public static List<Car> getCarsFiltered(String carColor) {
        return find("color like ?1", carColor).list();
    }

}
