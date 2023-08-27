package database.commands;

import client.AskIn;
import client.ReaderManager;

import java.io.BufferedInputStream;

public class ExecuteScript implements Command{

    @Override
    public void execute(Object obj) {
        BufferedInputStream bufferedInputStream = (BufferedInputStream) obj;
        ReaderManager.turnOnFile(bufferedInputStream);
        AskIn.turnOffFriendly();
    }
}
