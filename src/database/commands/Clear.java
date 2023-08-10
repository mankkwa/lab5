package database.commands;

import database.dao.PriorityQueueDAO;

import java.util.Arrays;
import java.util.List;

/**
 * Команда клеар - очищаем коллекцию
 */
public class Clear implements Command{
    @Override
    public void execute(Object obj) {
        //PriorityQueueDAO.organizations.clear();
    }

    @Override
    public List<Class> getArgsType() {
        return Arrays.asList();
    }
}
