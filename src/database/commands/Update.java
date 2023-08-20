package database.commands;

import database.dao.DAO;
import database.dao.PriorityQueueDAO;
import models.Organization;

import java.util.Arrays;
import java.util.List;

/**
 * Команда упдате - обновить значение элемента коллекции
 */

public class Update implements Command {
    private static final DAO priorityQueueDAO = new PriorityQueueDAO();

    @Override
    public void execute(Object newObject) {
        Organization org = (Organization) newObject;
        //тут вроде мы получаем айди переданного сюда org и если он null, то элемент не будет обновлен
        //в ином случае - обновлен
        Long id = org.getId();
        if (id == null){
            System.out.println("Элемент не будет обновлён, ведь такого id не существует :(");
        } else {
            priorityQueueDAO.update(id, org);
            priorityQueueDAO.sort();
            System.out.print("Элемент обновлён :)\n");
        }
    }
}
