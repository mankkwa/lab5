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
            System.out.println("Элемент не будет обновлён :(");
        } else {
            priorityQueueDAO.update(id, org);
            System.out.print("Элемент обновлён :)\n");
        }
    }
    /*

        if(PriorityQueueDAO.organizations.removeIf(u -> u.getId() == id)){
            Organization organization = (Organization)args.get(0);
            organization.setId((long)id);
            PriorityQueueDAO.organizations.add(organization);
            System.out.println("Элемент успешно сменен");
        }
        else{
            System.out.println("Такого элемента не существует");
        }
    }
*/
    @Override
    public List<Class> getArgsType() {
        return Arrays.asList();
    }

    }
