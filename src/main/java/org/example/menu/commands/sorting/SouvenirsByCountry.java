package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

import java.util.Scanner;

public class SouvenirsByCountry implements Command {
    @Override
    public void execute() {
        System.out.println("*** Вывод информации про сувениры, изготовленые в указаной стране. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.new DefaultSort().InfoAboutSouvenirsMadeThisCountry(choiceCountry());
        System.out.println();
    }

    private String choiceCountry() {
        System.out.println("Введите название страны для сортировки: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
