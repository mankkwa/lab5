package database.commands;

import models.*;
import database.dao.*;

import java.util.Arrays;
import java.util.List;

/**
 * Команда add - добавляем элемент в коллекцию
 */
public class Add implements Command {
        private static final DAO priorityQueueDAO = new PriorityQueueDAO();

    @Override
    public void execute (Object newObject) {
            Organization org = (Organization) newObject;
            priorityQueueDAO.add(org);
            System.out.println("Элемент добавлен в коллекцию!");
        }
}
