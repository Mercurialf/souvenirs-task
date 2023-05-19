package org.example.products.manufacturer;

public class ManufacturerBuilder {
    private String name;
    private String country;

    public ManufacturerBuilder() {
        this.name = "Default";
        this.country = "Default";
    }

    public ManufacturerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ManufacturerBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public Manufacturer build() {
        return new Manufacturer(name, country);
    }
}
