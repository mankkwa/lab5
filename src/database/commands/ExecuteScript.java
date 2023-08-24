package database.commands;

import client.AskIn;
import client.CommandManager;
import client.ReaderManager;
import client.handlers.FileInputHandler;
import models.exceptions.EndException;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ExecuteScript implements Command{

    @Override
    public void execute(Object obj) {
        BufferedInputStream bufferedInputStream = (BufferedInputStream) obj;
        ReaderManager.turnOnFile(bufferedInputStream);
        AskIn.turnOffFriendly();
    }
}
