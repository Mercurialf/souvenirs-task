package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

import java.util.Scanner;

public class ManufacturerByPrice implements Command {
    @Override
    public void execute() {
        System.out.println("*** Информация о производителях сувениров с ценой ниже указаной. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.new DefaultSort().InfoAboutManufacturersWhosePriceLessThen(getTargetPrice());
    }

    private double getTargetPrice() {
        System.out.println("Введи цену: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
