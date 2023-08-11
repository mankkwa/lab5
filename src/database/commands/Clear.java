package database.commands;

import database.dao.DAO;
import database.dao.PriorityQueueDAO;

import java.util.Arrays;
import java.util.List;

/**
 * Команда клеар - очищаем коллекцию
 */
public class Clear implements Command{
    private static final DAO priorityQueueDAO = new PriorityQueueDAO();

    @Override
    public void execute(Object obj) {
        //тут я воспользовалась просто методом clear, не стала изобретать велосипед
        if (priorityQueueDAO.size() != 0){
            priorityQueueDAO.clear();
            System.out.println("Коллекция очищена.");
        } else {
            System.err.println("Коллекция изначально пуста.");
        }
    }

    @Override
    public List<Class> getArgsType() {
        return Arrays.asList();
    }
}
