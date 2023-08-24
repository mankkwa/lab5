package database.commands;

import models.exceptions.EndException;

public class Exit implements Command {
    @Override
    public void execute(Object obj){
        System.out.println("Выхожу из программы...");
        System.exit(0);
    }
}

