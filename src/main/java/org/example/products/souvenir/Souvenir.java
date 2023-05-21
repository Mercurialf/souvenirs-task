package org.example.products.souvenir;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Souvenir {
    private String name;
    private String manufacturer;
    private LocalDate releaseDate;
    private double price;
}
