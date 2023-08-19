package client;

import database.FileManager;
import database.dao.PriorityQueueDAO;

public class Main {

    public static void main(String[] args) throws Exception {
        PriorityQueueDAO pqd = new PriorityQueueDAO();
        String output = args[0];
        AskIn.friendlyInterface();
        pqd.readCollection(output);
        CommandManager.whichCommand(output);

    }
}
