package org.example.products.manufacturer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {
    Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = createManufacturer();
    }

    @Test
    void TestGetName() {
        assertEquals("Microsoft", manufacturer.getName());
    }

    @Test
    void TestSetName() {
        manufacturer.setName("Apple");
        assertEquals("Apple", manufacturer.getName());
    }

    @Test
    void TestGetCountry() {
        assertEquals("USA", manufacturer.getCountry());
    }

    @Test
    void TestSetCountry() {
        manufacturer.setCountry("Italy");
        assertEquals("Italy", manufacturer.getCountry());
    }

    @Test
    void TestToString() {
        String info = "Manufacturer(name=Microsoft, country=USA)";
        assertEquals(info, manufacturer.toString());
    }

    private Manufacturer createManufacturer() {
        return new Manufacturer("Microsoft", "USA");
    }
}