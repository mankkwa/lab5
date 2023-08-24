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
            try {
                if (org != null) {
                    priorityQueueDAO.add(org);
                    priorityQueueDAO.sort();
                    System.out.println("Элемент добавлен в коллекцию!");
                }
            }catch (NullPointerException e){
                System.err.println(e.getMessage());
            }
        }
}
