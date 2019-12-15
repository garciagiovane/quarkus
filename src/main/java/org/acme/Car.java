package org.acme;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Car extends PanacheMongoEntity {

    @NotBlank(message = "Brand must not be blank")
    private String brand;
    @NotNull(message = "Color must not be blank")
    private String color;

}
