package database.commands;

import models.*;
import database.dao.*;

import java.util.Arrays;
import java.util.List;

/**
 * Команда add - добавляем элемент в коллекцию
 */
public class Add implements Command {
    @Override
    public void execute(List<Object> args) {
        PriorityQueueDAO.organizations.add((Organization) args.get(0));
    }

    @Override
    public List<Class> getArgsType() {
        return Arrays.asList(Organization.class);
    }
}
