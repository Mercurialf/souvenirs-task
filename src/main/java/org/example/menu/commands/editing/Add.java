package org.example.menu.commands.editing;

import org.example.data.FileManager;
import org.example.menu.Command;
import org.example.products.SouvenirCollection;
import org.example.products.manufacturer.Manufacturer;
import org.example.products.manufacturer.ManufacturerBuilder;
import org.example.products.souvenir.Souvenir;
import org.example.products.souvenir.SouvenirBuilder;
import org.example.utility.Config;

import java.time.LocalDate;
import java.util.Scanner;

public class Add implements Command {
    @Override
    public void execute() {
        System.out.println("*** Добавить сувенир или производителя. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        int userChoice = choice();
        if (userChoice == 0) {
            addManufacturer(souvenirCollection);
        }
        if (userChoice == 1) {
            addSouvenir(souvenirCollection);
        }
    }

    private int choice() {
        System.out.println("Введите '0' чтобы добавить производителя, и '1' чтобы добавить сувенир.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void addSouvenir(SouvenirCollection souvenirCollection) {
        System.out.println("Введите имя, производителя, дату выпуска и цену:");
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        Souvenir souvenir = new SouvenirBuilder()
                .setName(info[0])
                .setManufacturer(info[1])
                .setReleaseDate(LocalDate.parse(info[2]))
                .setPrice(Double.parseDouble(info[3]))
                .build();
        souvenirCollection.addSouvenir(souvenir);
        saveChange(souvenirCollection);
    }
    private void addManufacturer(SouvenirCollection souvenirCollection) {
        System.out.println("Введите имя и страну прозводителя:");
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        Manufacturer manufacturer = new ManufacturerBuilder()
                .setName(info[0])
                .setCountry(info[1])
                .build();
        souvenirCollection.addManufacturer(manufacturer);
        saveChange(souvenirCollection);
    }

    private void saveChange(SouvenirCollection souvenirCollection) {
        FileManager.saveManufacturersToFile(
                Config.DEFAULT_MANUFACTURER_TEXT_FILE,
                souvenirCollection.getManufacturerList());
        FileManager.saveSouvenirsToFile(
                Config.DEFAULT_SOUVENIR_TEXT_FILE,
                souvenirCollection.getSouvenirList()
        );
        System.out.println("Изменения сохранены.");
    }
}
