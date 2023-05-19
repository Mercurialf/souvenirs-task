package org.example.menu.commands.editing;

import org.example.data.FileManager;
import org.example.menu.Command;
import org.example.products.SouvenirCollection;
import org.example.utility.Config;

import java.util.Scanner;

public class Remove implements Command {
    @Override
    public void execute() {
        System.out.println("*** Удалить производителя и сувениры. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.deleteManufacturerAndSouvenirs(getManufacturerName());
        saveChange(souvenirCollection);
    }

    private String getManufacturerName() {
        System.out.println("Введите название производителя: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
