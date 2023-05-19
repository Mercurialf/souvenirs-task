package org.example.menu.commands.editing;

import org.example.data.FileManager;
import org.example.menu.Command;
import org.example.products.SouvenirCollection;
import org.example.utility.Config;

import java.time.LocalDate;
import java.util.Scanner;

public class Edit implements Command {
    @Override
    public void execute() {
        System.out.println("*** Редактировать сувенир или производителя. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        int userChoice = choice();
        if (userChoice == 0) {
            editManufacturer(souvenirCollection);
        }
        if (userChoice == 1) {
            editSouvenir(souvenirCollection);
        }
        System.out.println();
    }

    private int choice() {
        System.out.println("Чтобы редактировать производителя, введите - '0', сувенир - '1':");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void editManufacturer(SouvenirCollection souvenirCollection) {
        System.out.println("Введите имя производителя для редактирования:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите новое имя:");
        String newName = scanner.nextLine();
        System.out.println("Укажите страну производителя:");
        String country = scanner.nextLine();
        souvenirCollection.editManufacturer(name, newName, country);
        saveChange(souvenirCollection);
    }

    private void editSouvenir(SouvenirCollection souvenirCollection) {
        System.out.println("Введите имя и производителя сувенира:");
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        System.out.println("Введите новое имя, производителя, дату выпуска и цену:");
        String[] newInfo = scanner.nextLine().split(" ");
        souvenirCollection.editSouvenir(
                info[0], info[1],
                newInfo[0], newInfo[1],
                LocalDate.parse(newInfo[2]),
                Double.parseDouble(newInfo[3]));
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
