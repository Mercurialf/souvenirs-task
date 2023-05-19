package org.example.products;

import org.example.products.manufacturer.Manufacturer;
import org.example.products.manufacturer.ManufacturerBuilder;
import org.example.products.souvenir.Souvenir;
import org.example.products.souvenir.SouvenirBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SouvenirCollectionTest {
    SouvenirCollection souvenirCollection;
    SouvenirCollection souvenirCollectionForSorting;

    @BeforeEach
    void setUp() {
        souvenirCollection = new SouvenirCollection();
        souvenirCollection.getSouvenirList().clear();
        souvenirCollection.getManufacturerList().clear();

        souvenirCollectionForSorting = createSomeSouvenirsAndManufacturers();
    }

    @Test
    void TestAddSouvenir() {
        assertEquals(0, souvenirCollection.getSouvenirList().size());
        Souvenir souvenir = new SouvenirBuilder().build();
        souvenirCollection.addSouvenir(souvenir);
        assertEquals(1, souvenirCollection.getSouvenirList().size());
    }

    @Test
    void TestGetSouvenirList() {
        SouvenirCollection newSouvenirCollection = new SouvenirCollection();
        newSouvenirCollection.getSouvenirList().clear();
        assertEquals(newSouvenirCollection.getSouvenirList(), souvenirCollection.getSouvenirList());
    }

    @Test
    void TestAddManufacturer() {
        assertEquals(0, souvenirCollection.getManufacturerList().size());
        Manufacturer manufacturer = new ManufacturerBuilder().build();
        souvenirCollection.addManufacturer(manufacturer);
        assertEquals(1, souvenirCollection.getManufacturerList().size());
    }

    @Test
    void TestGetManufacturerList() {
        SouvenirCollection newSouvenirCollection = new SouvenirCollection();
        newSouvenirCollection.getManufacturerList().clear();
        assertEquals(newSouvenirCollection.getManufacturerList() , souvenirCollection.getManufacturerList());
    }

    @Test
    void TestEditSouvenir() {
        Souvenir souvenir = new SouvenirBuilder().build();
        souvenirCollection.addSouvenir(souvenir);
        souvenirCollection.editSouvenir("Default", "Default",
                "Cup", "Microsoft",
                LocalDate.of(2021, 3, 13), 33.8);
        assertEquals("Cup", souvenirCollection.getSouvenirList().get(0).getName());
        assertEquals("Microsoft", souvenirCollection.getSouvenirList().get(0).getManufacturer());
        assertEquals(LocalDate.of(2021, 3, 13),
                souvenirCollection.getSouvenirList().get(0).getReleaseDate());
        assertEquals(33.8, souvenirCollection.getSouvenirList().get(0).getPrice());

    }

    @Test
    void TestEditManufacturer() {
        Manufacturer manufacturer = new ManufacturerBuilder().setName("SpaceX").build();
        souvenirCollection.addManufacturer(manufacturer);
        souvenirCollection.editManufacturer("SpaceX", "NeoSpaceX", "USA");
        assertEquals("NeoSpaceX", souvenirCollection.getManufacturerList().get(0).getName());
        assertEquals("USA", souvenirCollection.getManufacturerList().get(0).getCountry());
    }

    @Test
    void TestDeleteManufacturerAndSouvenirs() {
        Manufacturer manufacturer = new ManufacturerBuilder().setName("Apple").setCountry("USA").build();
        Souvenir souvenir = new SouvenirBuilder().setName("Iphone").setManufacturer("Apple").setPrice(300).build();
        souvenirCollection.addSouvenir(souvenir);
        souvenirCollection.addManufacturer(manufacturer);
        assertEquals(1, souvenirCollection.getSouvenirList().size());
        souvenirCollection.deleteManufacturerAndSouvenirs("Apple");
        assertEquals(0, souvenirCollection.getSouvenirList().size());
    }

    @Test
    void TestInfoAboutSouvenirsOfTheGivenManufacturer() {
        souvenirCollectionForSorting.new DefaultSort().InfoAboutSouvenirsOfTheGivenManufacturer("Apple");
    }

    @Test
    void TestInfoAboutSouvenirsMadeThisCountry() {
        souvenirCollectionForSorting.new DefaultSort().InfoAboutSouvenirsMadeThisCountry("USA");
    }

    @Test
    void TestInfoAboutManufacturersWhosePriceLessThen() {
        souvenirCollectionForSorting.new DefaultSort().InfoAboutManufacturersWhosePriceLessThen(50);
    }

    @Test
    void TestInfoAboutManufacturersAndAllSouvenirs() {
        souvenirCollectionForSorting.new DefaultSort().InfoAboutManufacturersAndAllSouvenirs();
    }

    @Test
    void TestInfoAboutManufacturersOfGivenSouvenirProducedGivenYear() {
        souvenirCollectionForSorting.new DefaultSort()
                .InfoAboutManufacturersOfGivenSouvenirProducedGivenYear("Phone", 2013);
    }

    @Test
    void TestInfoAboutSouvenirsMadeThisYear() {
        souvenirCollectionForSorting.new DefaultSort().InfoAboutSouvenirsMadeThisYear();
    }

    private SouvenirCollection createSomeSouvenirsAndManufacturers() {
        SouvenirCollection souvenirCollectionForSorting = new SouvenirCollection();
        souvenirCollectionForSorting.getSouvenirList().clear();
        souvenirCollectionForSorting.getManufacturerList().clear();

        Souvenir cup = new SouvenirBuilder().setName("Cup").setManufacturer("Microsoft")
                .setReleaseDate(LocalDate.of(2020, 12, 1)).setPrice(99.9).build();
        Souvenir phone = new SouvenirBuilder().setName("Phone").setManufacturer("Apple")
                .setReleaseDate(LocalDate.of(2013, 3, 15)).build();
        souvenirCollectionForSorting.addSouvenir(cup);
        souvenirCollectionForSorting.addSouvenir(phone);

        Manufacturer apple = new ManufacturerBuilder().setName("Apple").build();
        Manufacturer microsoft = new ManufacturerBuilder().setName("Microsoft").setCountry("USA").build();
        souvenirCollectionForSorting.addManufacturer(apple);
        souvenirCollectionForSorting.addManufacturer(microsoft);
        return souvenirCollectionForSorting;
    }
}