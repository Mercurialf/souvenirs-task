package org.example.products.souvenir;

import java.time.LocalDate;

public class SouvenirBuilder {
    private String name;
    private String manufacturer;
    private LocalDate releaseDate;
    private double price;

    public SouvenirBuilder() {
        this.name = "Default";
        this.manufacturer = "Default";
        this.releaseDate = LocalDate.of(1900, 1, 1);
        this.price = 0.0;
    }

    public SouvenirBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SouvenirBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public SouvenirBuilder setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public SouvenirBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Souvenir build() {
        return new Souvenir(name, manufacturer, releaseDate, price);
    }
}
