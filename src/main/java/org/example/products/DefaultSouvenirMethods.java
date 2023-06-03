package org.example.products;

import org.example.products.manufacturer.Manufacturer;
import org.example.products.souvenir.Souvenir;

import java.time.LocalDate;

public interface DefaultSouvenirMethods {
    void addSouvenir(Souvenir souvenir);

    void addManufacturer(Manufacturer manufacturer);

    void editSouvenir(String name, String manufacturer,
                      String newName, String newManufacturer,
                      LocalDate releaseDate, double price);

    void editManufacturer(String name, String newName, String country);

    void printAllSouvenirs();

    void printAllManufacturer();

    void deleteManufacturerAndSouvenirs(String name);
}
