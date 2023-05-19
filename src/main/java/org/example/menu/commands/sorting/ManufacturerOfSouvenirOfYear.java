package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

import java.util.Scanner;

public class ManufacturerOfSouvenirOfYear implements Command {
    @Override
    public void execute() {
        System.out.println("*** Информация о производителях указаного сувенира, изготовленного в указаный год. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection
                .new DefaultSort()
                .InfoAboutManufacturersOfGivenSouvenirProducedGivenYear(getSouvenirName(), getYear());
    }

    private String getSouvenirName() {
        System.out.println("Введите название сувенира: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getYear() {
        System.out.println("Введите год: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
