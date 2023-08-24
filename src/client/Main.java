package client;

import client.handlers.ConsoleInputHandler;
import database.dao.PriorityQueueDAO;

public class Main {

    public static void main(String[] args) throws Exception {
        PriorityQueueDAO pqd = new PriorityQueueDAO();
        String output = args[0];

        pqd.readCollection(output);
        AskIn.chooseFriendly();
        ReaderManager.turnOnConsole();
        CommandManager.whichCommand(output);

    }
}
