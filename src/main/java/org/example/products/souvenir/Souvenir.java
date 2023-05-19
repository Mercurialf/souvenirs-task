package org.example.products.souvenir;

import java.time.LocalDate;

public class Souvenir {
    private String name;
    private String manufacturer;
    private LocalDate releaseDate;
    private double price;

    public Souvenir(String name, String manufacturer, LocalDate releaseDate, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}
