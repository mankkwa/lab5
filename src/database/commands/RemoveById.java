package database.commands;

import client.AskIn;
import database.dao.DAO;
import database.dao.PriorityQueueDAO;
import models.Organization;
import models.exceptions.EndException;

public class RemoveById implements Command{
    private static PriorityQueueDAO dao;
    @Override
    public void execute(Object obj) throws EndException {
        Organization organization = (Organization) obj;
        Long id = organization.getId();
        if(id != null) {
            dao.remove(id);
            dao.sort();
            System.out.println("Элемент был удален!");
        }

    }
}
