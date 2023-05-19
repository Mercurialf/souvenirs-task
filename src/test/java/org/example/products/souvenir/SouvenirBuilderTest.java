package org.example.products.souvenir;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SouvenirBuilderTest {
    Souvenir souvenir;
    @BeforeEach
    void setUp() {
        souvenir = new SouvenirBuilder().build();
    }

    @Test
    void TestSetName() {
        souvenir = new SouvenirBuilder().setName("Souvenir King").build();
        assertEquals("Souvenir King", souvenir.getName());
    }

    @Test
    void TestSetManufacturer() {
        souvenir = new SouvenirBuilder().setManufacturer("IBM").build();
        assertEquals("IBM", souvenir.getManufacturer());
    }

    @Test
    void TestSetReleaseDate() {
        souvenir = new SouvenirBuilder().setReleaseDate(LocalDate.of(2023, 1, 21)).build();
        assertEquals(LocalDate.of(2023, 1, 21), souvenir.getReleaseDate());
    }

    @Test
    void TestSetPrice() {
        souvenir = new SouvenirBuilder().setPrice(9.99).build();
        assertEquals(9.99, souvenir.getPrice());
    }

    @Test
    void TestBuild() {
        assertEquals("Default", souvenir.getName());
        assertEquals("Default", souvenir.getManufacturer());
        assertEquals(LocalDate.of(1900, 1, 1), souvenir.getReleaseDate());
        assertEquals(0.0, souvenir.getPrice());
    }
}