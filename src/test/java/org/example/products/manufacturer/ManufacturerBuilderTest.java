package org.example.products.manufacturer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerBuilderTest {
    Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new ManufacturerBuilder().build();
    }

    @Test
    void TestSetName() {
        manufacturer = new ManufacturerBuilder().setName("New Name").build();
        assertEquals("New Name", manufacturer.getName());
    }

    @Test
    void TestSetCountry() {
        manufacturer = new ManufacturerBuilder().setCountry("New Country").build();
        assertEquals("New Country", manufacturer.getCountry());
    }

    @Test
    void TestBuild() {
        assertEquals("Default", manufacturer.getName());
        assertEquals("Default", manufacturer.getCountry());
    }
}