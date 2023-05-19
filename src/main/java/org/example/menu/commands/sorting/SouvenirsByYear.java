package org.example.menu.commands.sorting;

import org.example.menu.Command;
import org.example.products.SouvenirCollection;

public class SouvenirsByYear implements Command {
    @Override
    public void execute() {
        System.out.println("*** Список сувениров по году выпуска. ***");
        SouvenirCollection souvenirCollection = new SouvenirCollection();
        souvenirCollection.new DefaultSort().InfoAboutSouvenirsMadeThisYear();
        System.out.println();
    }
}
