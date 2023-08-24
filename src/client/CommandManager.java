package client;

import client.ReaderManager.*;
import database.commands.*;
import database.dao.PriorityQueueDAO;
import models.Organization;
import models.exceptions.EndException;
import models.exceptions.ReaderException;


import java.io.BufferedInputStream;
import java.io.FileInputStream;

import static client.AskIn.*;


/**
 * Класс для работы с командами
 */
public class CommandManager {

    private static PriorityQueueDAO priorityQueueDAO = new PriorityQueueDAO();

    public static final Command[] commands = {
            new Add(),
            new Clear(),
            new Update(priorityQueueDAO),
            new Exit(),
            new Save(),
            new Show(),
            new RemoveById(),
            new ExecuteScript(),
    };

    private static void printMessage(String message){
        if (FRIEND_DETECTOR) {
            System.out.println(message);
        }
    }

    /**
     * whichFunction - функция для работы с запросом пользователя
     */
    public static Object whichFunction (int commandIndex, String fileName) throws EndException {
        Organization org = new Organization();
        AskIn ask = new AskIn();
        PriorityQueueDAO collection = new PriorityQueueDAO();
        Long id = 1L;
        switch (commandIndex){
            case 0:
                printMessage("< Вызвана команда add >");
                try {
                    org.setName(ask.askName(ReaderManager.getHandler()));
                    org.setType(ask.askType(ReaderManager.getHandler()));
                    org.setPostalAddress(ask.askPostalAddress(ReaderManager.getHandler()));
                    org.setCoordinates(ask.askCoordinates(ReaderManager.getHandler()));
                    org.setEmployeesCount(ask.askEmployeesCount(ReaderManager.getHandler()));
                    org.setAnnualTurnover(ask.askAnnualTurnover(ReaderManager.getHandler()));
                    org.setFullName(ask.askFullName(ReaderManager.getHandler()));
                } catch (EndException e){
                    System.err.println(e.getMessage());
                    org = null;
                    break;
                }
                break;
            case  1:
                printMessage("< Вызвана команда clear >");
                break;
            case 2:
                printMessage("< Вызвана команда update >");
                    try{
                        id = ask.askId(ReaderManager.getHandler());
                        if (collection.get(id) != null){
                            try{
                                org.setName(ask.askName(ReaderManager.getHandler()));
                                org.setType(ask.askType(ReaderManager.getHandler()));
                                org.setPostalAddress(ask.askPostalAddress(ReaderManager.getHandler()));
                                org.setCoordinates(ask.askCoordinates(ReaderManager.getHandler()));
                                org.setEmployeesCount(ask.askEmployeesCount(ReaderManager.getHandler()));
                                org.setAnnualTurnover(ask.askAnnualTurnover(ReaderManager.getHandler()));
                                org.setFullName(ask.askFullName(ReaderManager.getHandler()));
                                org.setId(id);
                            } catch (EndException e){
                                System.err.println(e.getMessage());
                            }
                        } else {
                            System.err.println("Такого элемента нет!");
                        }
                    } catch (EndException e){
                        System.err.println(e.getMessage());
                        break;
                    }
                break;
            case 3:
                printMessage("< Вызвана команда exit >");
                break;
            case 4:
                printMessage("< Вызвана команда save >");
                priorityQueueDAO.saveCollectionToFile(fileName);
                break;
            case 5:
                printMessage("< Вызвана команда show >");
                break;
            case 6:
                printMessage("< Вызвана команда remove_by_id >");
                    try {
                        id = ask.askId(ReaderManager.getHandler());
                        if (collection.get(id) != null) {
                            collection.get(id).setId(id);
                            return collection.get(id);
                        } else {
                            System.err.println("Такого элемента нет!");
                        }
                    } catch (EndException e) {
                        System.err.println(e.getMessage());
                    }
                break;
            case 7:
                printMessage("< Вызвана команда execute_script >");
                try {
                    FileInputStream fileInputStream = ask.askFileName(ReaderManager.getHandler());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    return bufferedInputStream;
                } catch (EndException e){
                    System.err.print(e.getMessage());
                }
                break;
        }
        return org;
    }

    public static void whichCommand(String fileName){
        String command = null;
        try {
            command = AskIn.askCommand(ReaderManager.getHandler());
        } catch (EndException | ReaderException e){
            System.err.println(e.getMessage());
            whichCommand(fileName);
            return;
        }
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        Object o = null;
        try {
            o = whichFunction(commandIndex, fileName);
        } catch (EndException e) {
            e.printStackTrace();
        }
        commands[commandIndex].execute(o);
        whichCommand(fileName);
        }
    }
