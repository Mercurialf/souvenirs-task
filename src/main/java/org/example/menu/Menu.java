package org.example.menu;

import java.util.List;

public class Menu {
    private final List<Command> commandList;

    public Menu(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void executeCommand(int index) {
        commandList.get(index).execute();
    }
}
