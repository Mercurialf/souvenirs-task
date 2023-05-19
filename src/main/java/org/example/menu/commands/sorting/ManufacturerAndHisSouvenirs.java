package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

public class ManufacturerAndHisSouvenirs implements Command {
    @Override
    public void execute() {
        System.out.println("*** Информация про производителя и его сувениры. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.new DefaultSort().InfoAboutManufacturersAndAllSouvenirs();
        System.out.println();
    }
}
