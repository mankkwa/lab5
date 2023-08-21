package database.commands;

import database.dao.DAO;
import models.Organization;

/**
 * Команда упдате - обновить значение элемента коллекции
 */

public class Update implements Command {
    private final DAO priorityQueueDAO;

    public Update(DAO priorityQueueDAO) {
        this.priorityQueueDAO = priorityQueueDAO;
    }

    @Override
    public void execute(Object newObject) {
        Organization org = (Organization) newObject;
        //тут вроде мы получаем айди переданного сюда org и если он null, то элемент не будет обновлен
        //в ином случае - обновлен
        if (priorityQueueDAO.get(org.getId()) == null){
            System.out.println("Элемент не будет обновлён, ведь такого id не существует :(");
        } else {
            priorityQueueDAO.update(org.getId(), org);
            priorityQueueDAO.sort();
            System.out.print("Элемент обновлён :)\n");
        }
    }
}
