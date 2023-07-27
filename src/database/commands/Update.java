package database.commands;

import database.dao.PriorityQueueDAO;
import models.Organization;

import java.util.Arrays;
import java.util.List;

public class Update implements Command{
    @Override
    public void execute(List<Object> args) {
        int id = (int)args.get(0);

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

    @Override
    public List<Class> getArgsType() {
        return Arrays.asList();
    }
}
