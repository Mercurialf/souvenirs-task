package org.example.products;

public interface DefaultSortTypes {
    void InfoAboutSouvenirsOfTheGivenManufacturer(String manufacturerName);

    void InfoAboutSouvenirsMadeThisCountry(String country);

    void InfoAboutManufacturersWhosePriceLessThen(double targetPrice);

    void InfoAboutManufacturersAndAllSouvenirs();

    void InfoAboutManufacturersOfGivenSouvenirProducedGivenYear(String souvenirName, int year);

    void InfoAboutSouvenirsMadeThisYear();
}
