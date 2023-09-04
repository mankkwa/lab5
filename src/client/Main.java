package client;

import database.dao.PriorityQueueDAO;

public class Main {

    public static void main(String[] args) throws Exception {
        PriorityQueueDAO pqd = new PriorityQueueDAO();
        String output = null;
        try {
            output = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Информация о аргументе командной строки отсутствует. Работа прекращена.");
            System.exit(0);
        }

        pqd.readCollection(output);
        AskIn.chooseFriendly();
        ReaderManager.turnOnConsole();
        CommandManager.whichCommand(output);

    }
}
