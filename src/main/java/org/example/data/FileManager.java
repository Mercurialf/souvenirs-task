package org.example.data;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.example.products.manufacturer.Manufacturer;
import org.example.products.souvenir.Souvenir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public static void loadSouvenirsFromFile(String filename, List<Souvenir> souvenirs) {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        souvenirs.clear();
        for (String line : lines) {
            String[] fields = line.split(",");
            String name = fields[0]
                    .replace("Souvenir{name=", "")
                    .replace("'", "");
            String manufacturer = fields[1]
                    .replace(" manufacturer=", "")
                    .replace("'", "");
            LocalDate releaseDate = LocalDate.parse(fields[2]
                    .replace(" releaseDate=", ""));
            double price = Double.parseDouble(fields[3]
                    .replace("price=", "")
                    .replace("}", ""));
            Souvenir souvenir = new Souvenir(name, manufacturer, releaseDate, price);
            souvenirs.add(souvenir);
        }
    }

    @SneakyThrows
    public static void loadManufacturersFromFile(String filename, List<Manufacturer> manufacturers) {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        manufacturers.clear();
        for (String line : lines) {
            String[] fields = line.split(",");
            String name = fields[0]
                    .replace("Manufacturer{name=", "")
                    .replace("'", "");
            String country = fields[1]
                    .replace(" country=", "")
                    .replace("'", "")
                    .replace("}", "");
            Manufacturer manufacturer = new Manufacturer(name, country);
            manufacturers.add(manufacturer);
        }
    }

    public static void loadAllList(String manufacturersFileName, List<Manufacturer> manufacturers,
                                   String souvenirsFileName, List<Souvenir> souvenirs) {
        loadManufacturersFromFile(manufacturersFileName, manufacturers);
        loadSouvenirsFromFile(souvenirsFileName, souvenirs);
    }
}
