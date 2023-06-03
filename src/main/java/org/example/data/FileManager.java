package org.example.data;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.example.products.manufacturer.Manufacturer;
import org.example.products.souvenir.Souvenir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class FileManager {
    @SneakyThrows
    public static void saveSouvenirsToFile(String filename, List<Souvenir> souvenirs) {
        @Cleanup
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        List<String> souvenirLines = souvenirs.stream()
                .map(Souvenir::toString)
                .toList();
        for (String line : souvenirLines) {
            writer.write(line);
            writer.newLine();
            writer.close();
        }
    }

    @SneakyThrows
    public static void saveManufacturersToFile(String filename, List<Manufacturer> manufacturers) {
        @Cleanup
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        List<String> manufacturerLines = manufacturers.stream()
                .map(Manufacturer::toString)
                .toList();
        for (String line : manufacturerLines) {
            writer.write(line);
            writer.newLine();
        }
    }

    @SneakyThrows
    private static void loadSouvenirsFromFile(String filename, List<Souvenir> souvenirs) {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        souvenirs.clear();
        for (String line : lines) {
            Souvenir souvenir = parseSouvenirFromString(line);
            souvenirs.add(souvenir);
        }
    }

    private static Souvenir parseSouvenirFromString(String line) {
        String[] fields = line.split(",");
        String name = parseFieldValue(fields[0], "Souvenir{name=", "'");
        String manufacturer = parseFieldValue(fields[1], " manufacturer=", "'");
        LocalDate releaseDate = LocalDate.parse(parseFieldValue(fields[2], " releaseDate=", ""));
        double price = Double.parseDouble(parseFieldValue(fields[3], "price=", "}"));
        return new Souvenir(name, manufacturer, releaseDate, price);
    }

    @SneakyThrows
    private static void loadManufacturersFromFile(String filename, List<Manufacturer> manufacturers) {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        manufacturers.clear();
        for (String line : lines) {
            Manufacturer manufacturer = parseManufacturerFromString(line);
            manufacturers.add(manufacturer);
        }
    }

    private static Manufacturer parseManufacturerFromString(String line) {
        String[] fields = line.split(",");
        String name = parseFieldValue(fields[0], "Manufacturer{name=", "'");
        String country = parseFieldValue(fields[1], " country=", "").replace("}", "");
        return new Manufacturer(name, country);
    }

    private static String parseFieldValue(String field, String prefix, String suffix) {
        return field.replace(prefix, "").replace(suffix, "");
    }

    public static void loadAllList(String manufacturersFileName, List<Manufacturer> manufacturers,
                                   String souvenirsFileName, List<Souvenir> souvenirs) {
        loadManufacturersFromFile(manufacturersFileName, manufacturers);
        loadSouvenirsFromFile(souvenirsFileName, souvenirs);
    }
}