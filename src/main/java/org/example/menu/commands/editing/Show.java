package org.example.menu.commands.editing;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

import java.util.Scanner;

public class Show implements Command {
    @Override
    public void execute() {
        System.out.println("*** Показать все сувениры и производителей. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        choice(souvenirCollection);
    }

    private void choice(SouvenirCollection souvenirCollection) {
        System.out.println("Введите '0' для просмотра списка производителей, и '1' для просмотра списка сувениров.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            printAllManufacturers(souvenirCollection);
        }
        if (choice == 1) {
            printAllSouvenirs(souvenirCollection);
        }
    }

    private void printAllSouvenirs(SouvenirCollection souvenirCollection) {
        System.out.println("Список всех сувениров:");
        souvenirCollection.printAllSouvenirs();
        System.out.println();
    }

    private void printAllManufacturers(SouvenirCollection souvenirCollection) {
        System.out.println("Список всех производителей:");
        souvenirCollection.printAllManufacturer();
        System.out.println();
    }
}
