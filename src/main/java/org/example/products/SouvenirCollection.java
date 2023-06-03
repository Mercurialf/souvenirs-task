package org.example.products;

import org.example.data.FileManager;
import org.example.products.manufacturer.Manufacturer;
import org.example.products.souvenir.Souvenir;
import org.example.utility.Config;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SouvenirCollection implements DefaultSouvenirMethods {
    private final List<Souvenir> souvenirList;
    private final List<Manufacturer> manufacturerList;

    public SouvenirCollection() {
        souvenirList = new ArrayList<>();
        manufacturerList = new ArrayList<>();
        loadAllFromFIle();
    }

    @Override
    public void addSouvenir(Souvenir souvenir) {
        souvenirList.add(souvenir);
    }

    public List<Souvenir> getSouvenirList() {
        return souvenirList;
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerList.add(manufacturer);
    }

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    @Override
    public void editSouvenir(String name, String manufacturer,
                             String newName, String newManufacturer, LocalDate releaseDate, double price) {
        Souvenir souvenir = searchSouvenir(name, manufacturer);
        if (souvenir != null) {
            souvenirList.remove(souvenir);
            souvenir.setName(newName);
            souvenir.setManufacturer(newManufacturer);
            souvenir.setReleaseDate(releaseDate);
            souvenir.setPrice(price);
            souvenirList.add(souvenir);
        }
    }

    private Souvenir searchSouvenir(String name, String manufacturer) {
        return souvenirList.stream()
                .filter(s -> Objects.equals(s.getName(), name) && Objects.equals(s.getManufacturer(), manufacturer))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Сувенир с указаным именем не найден."));
    }

    @Override
    public void editManufacturer(String name, String newName, String country) {
        Manufacturer manufacturer = searchManufacturer(name);
        if (manufacturer != null) {
            manufacturerList.remove(manufacturer);
            manufacturer.setName(newName);
            manufacturer.setCountry(country);
            manufacturerList.add(manufacturer);
        }
    }

    private Manufacturer searchManufacturer(String name) {
        return manufacturerList.stream()
                .filter(m -> Objects.equals(m.getName(), name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Производитель с указаным именем не найден."));
    }

    @Override
    public void printAllSouvenirs() {
        souvenirList.forEach(System.out::println);
    }

    @Override
    public void printAllManufacturer() {
        manufacturerList.forEach(System.out::println);
    }

    @Override
    public void deleteManufacturerAndSouvenirs(String name) {
        souvenirList.stream()
                .filter(souvenir -> Objects.equals(souvenir.getManufacturer(), name))
                .toList()
                .forEach(souvenirList::remove);
        manufacturerList.removeIf(manufacturer -> Objects.equals(manufacturer.getName(), name));
    }

    private void loadAllFromFIle() {
        FileManager.loadAllList(Config.DEFAULT_MANUFACTURER_TEXT_FILE, getManufacturerList(),
                Config.DEFAULT_SOUVENIR_TEXT_FILE, getSouvenirList());
    }

    public class DefaultSort implements DefaultSortTypes {
        @Override
        public void InfoAboutSouvenirsOfTheGivenManufacturer(String manufacturerName) {
            souvenirList.stream()
                    .filter(s -> Objects.equals(s.getManufacturer(), manufacturerName))
                    .forEach(System.out::println);
        }

        @Override
        public void InfoAboutSouvenirsMadeThisCountry(String country) {
            souvenirList.stream()
                    .filter(souvenir -> {
                        String manufacturerCountry = getManufacturerCountry(souvenir);
                        return manufacturerCountry != null && manufacturerCountry.equals(country);
                    })
                    .forEach(System.out::println);
        }

        private String getManufacturerCountry(Souvenir souvenir) {
            Manufacturer manufacturer = manufacturerList.stream()
                    .filter(m -> Objects.equals(m.getName(), souvenir.getManufacturer()))
                    .findAny()
                    .orElse(null);
            return manufacturer != null ? manufacturer.getCountry() : null;
        }

        @Override
        public void InfoAboutManufacturersWhosePriceLessThen(double targetPrice) {
            List<String> filteredManufacturers = souvenirList
                    .stream()
                    .filter(souvenir -> souvenir.getPrice() < targetPrice)
                    .map(Souvenir::getManufacturer)
                    .distinct()
                    .toList();
            filteredManufacturers.forEach(System.out::println);
        }

        @Override
        public void InfoAboutManufacturersAndAllSouvenirs() {
            manufacturerList.forEach(manufacturer -> {
                System.out.println("Производитель: " + manufacturer.getName());
                List<Souvenir> manufacturerSouvenirs = getManufacturerSouvenirs(manufacturer.getName());
                manufacturerSouvenirs.forEach(souvenir -> {
                    System.out.println("   Сувенир: "
                            + souvenir.getName() + " "
                            + souvenir.getReleaseDate() + " "
                            + souvenir.getPrice());
                });
            });
        }

        @Override
        public void InfoAboutManufacturersOfGivenSouvenirProducedGivenYear(String souvenirName, int year) {
            List<String> manufacturerNames = souvenirList.stream()
                    .filter(s -> Objects.equals(s.getName(), souvenirName) && s.getReleaseDate().getYear() == year)
                    .map(Souvenir::getManufacturer)
                    .distinct()
                    .toList();
            if (manufacturerNames.isEmpty()) {
                System.out.println("Нет информации о производителях сувенира '" + souvenirName
                        + "', произведенных в " + year);
            } else {
                System.out.println("Производители сувенира '" + souvenirName
                        + "', произведенного в " + year + ":");
                manufacturerNames.forEach(System.out::println);
            }
        }

        @Override
        public void InfoAboutSouvenirsMadeThisYear() {
            Map<Integer, List<Souvenir>> souvenirsByYear = souvenirList.stream()
                    .collect(Collectors.groupingBy(souvenir -> souvenir.getReleaseDate().getYear()));
            souvenirsByYear.forEach((year, souvenirList) -> {
                System.out.println("Год: " + year);
                souvenirList.forEach(souvenir -> {
                    System.out.println("   Сувенир: " + souvenir.getName()
                            + " Производитель: " + souvenir.getManufacturer());
                });
            });
        }

        private List<Souvenir> getManufacturerSouvenirs(String manufacturerName) {
            return souvenirList.stream()
                    .filter(souvenir -> Objects.equals(souvenir.getManufacturer(), manufacturerName))
                    .toList();
        }
    }
}