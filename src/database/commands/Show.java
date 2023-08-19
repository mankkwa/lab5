package database.commands;

import database.dao.PriorityQueueDAO;
import models.exceptions.EndException;

public class Show implements Command{
    private static PriorityQueueDAO pqd = new PriorityQueueDAO();
    @Override
    public void execute(Object obj) throws EndException {
        System.out.println(pqd.show());
    }
}
