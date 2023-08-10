package database.commands;

import client.handlers.InputHandler;
import database.AskIn;
import models.*;
import database.dao.*;
import models.exceptions.EndException;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Команда add - добавляем элемент в коллекцию
 */
public class Add implements Command {
        PriorityQueueDAO priorityQueueDAO;
        private final AskIn ask = new AskIn();
        InputHandler ih;


    @Override
    public void execute (Object newObject) {
            Organization org = new Organization();
            try {
                org = new Organization(ask.askId(ih),
                        ask.askName(ih),
                        ask.askCoordinates(ih),
                        ZonedDateTime.now(),
                        ask.askAnnualTurnover(ih),
                        ask.askType(ih),
                        ask.askEmployeesCount(ih),
                        ask.askPostalAddress(ih),
                        ask.askFullName(ih));

            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                return;
            } catch (EndException e) {
                e.printStackTrace();
            }
            priorityQueueDAO.add(org);
            System.out.print("Элемент добавлен в коллекцию!");
        }

    @Override
    public List<Class> getArgsType() {
        return Arrays.asList(Organization.class);
    }
}
