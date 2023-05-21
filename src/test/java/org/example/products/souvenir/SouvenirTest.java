package org.example.products.souvenir;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SouvenirTest {
    Souvenir souvenir;

    @BeforeEach
    void setUp() {
        souvenir = createSouvenir();
    }

    @Test
    void TestGetName() {
        assertEquals("Cup", souvenir.getName());
    }

    @Test
    void TestSetName() {
        souvenir.setName("Old Cup");
        assertEquals("Old Cup", souvenir.getName());
    }

    @Test
    void TestGetManufacturer() {
        assertEquals("Microsoft", souvenir.getManufacturer());
    }

    @Test
    void TestSetManufacturer() {
        souvenir.setManufacturer("Apple");
        assertEquals("Apple", souvenir.getManufacturer());
    }

    @Test
    void TestGetReleaseDate() {
        assertEquals(LocalDate.of(1997, 5, 13), souvenir.getReleaseDate());
    }

    @Test
    void TestSetReleaseDate() {
        souvenir.setReleaseDate(LocalDate.of(2022, 5, 21));
        assertEquals(LocalDate.of(2022, 5, 21), souvenir.getReleaseDate());
    }

    @Test
    void TestGetPrice() {
        assertEquals(12.99, souvenir.getPrice(), 1e-9);
    }

    @Test
    void TestSetPrice() {
        souvenir.setPrice(8.33);
        assertEquals(8.33, souvenir.getPrice(), 1e-9);
    }

    @Test
    void TestToString() {
        String info = "Souvenir(name=Cup, manufacturer=Microsoft, releaseDate=1997-05-13, price=12.99)";
        assertEquals(info, souvenir.toString());
    }

    private Souvenir createSouvenir() {
        return new Souvenir(
                "Cup",
                "Microsoft",
                LocalDate.of(1997, 5, 13),
                12.99);
    }
}