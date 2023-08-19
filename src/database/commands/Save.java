package database.commands;

import database.dao.PriorityQueueDAO;
import models.exceptions.EndException;

public class Save implements Command{
    private static PriorityQueueDAO pqd = new PriorityQueueDAO();
    private static String output;

    @Override
    public void execute(Object obj) throws EndException {

    }
}
