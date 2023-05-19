package org.example;

import org.example.menu.Command;
import org.example.menu.Menu;
import org.example.menu.commands.editing.Add;
import org.example.menu.commands.editing.Edit;
import org.example.menu.commands.editing.Remove;
import org.example.menu.commands.editing.Show;
import org.example.menu.commands.sorting.*;
import org.example.utility.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.CommandMenu();
    }

    private void CommandMenu() {
        Menu menu = new Menu(createCommand());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Config.THE_MOST_STYLISH_CONSOLE_MENU);
            int choice = scanner.nextInt();
            if (choice == 10) {
                break;
            }
            menu.executeCommand(choice);
        }
        System.out.println("Выход из программы.");
    }

    private List<Command> createCommand() {
        List<Command> commandList = new ArrayList<>(10);
        commandList.addAll(createEditingCommand());
        commandList.addAll(createSortingCommand());
        return commandList;
    }

    private List<Command> createEditingCommand() {
        Command add = new Add();
        Command edit = new Edit();
        Command remove = new Remove();
        Command show = new Show();

        List<Command> commandList = new ArrayList<>(4);
        commandList.add(add);
        commandList.add(edit);
        commandList.add(remove);
        commandList.add(show);
        return commandList;
    }

    private List<Command> createSortingCommand() {
        Command souvenirsByCounty = new SouvenirsByCountry();
        Command souvenirsByManufacturer = new SouvenirsByManufacturer();
        Command souvenirsByYear = new SouvenirsByYear();
        Command manufacturerAndHisSouvenirs = new ManufacturerAndHisSouvenirs();
        Command manufacturerByPrice = new ManufacturerByPrice();
        Command manufacturerOfSouvenirOfYear = new ManufacturerOfSouvenirOfYear();

        List<Command> commandList = new ArrayList<>(6);
        commandList.add(souvenirsByCounty);
        commandList.add(souvenirsByManufacturer);
        commandList.add(souvenirsByYear);
        commandList.add(manufacturerAndHisSouvenirs);
        commandList.add(manufacturerByPrice);
        commandList.add(manufacturerOfSouvenirOfYear);
        return commandList;
    }
}