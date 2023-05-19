package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

import java.util.Scanner;

public class SouvenirsByManufacturer implements Command {
    @Override
    public void execute() {
        System.out.println("*** Вывод информации про сувениры указаного производителя. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.new DefaultSort().InfoAboutSouvenirsOfTheGivenManufacturer(choiceCountry());
        System.out.println();
    }

    private String choiceCountry() {
        System.out.println("Введите название производителя: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
