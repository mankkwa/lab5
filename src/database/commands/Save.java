package database.commands;

import database.dao.PriorityQueueDAO;
import models.exceptions.EndException;

import java.io.IOException;

public class Save implements Command{
    private static PriorityQueueDAO pqd = new PriorityQueueDAO();

    @Override
    public void execute(Object obj) {
            pqd.sort();
    }
}
