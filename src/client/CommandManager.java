package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;
import database.commands.*;
import database.dao.DAO;
import database.dao.PriorityQueueDAO;
import models.Organization;
import models.exceptions.EndException;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для работы с командами
 */
public class CommandManager {

    private static InputHandler ih;
    private static PriorityQueueDAO priorityQueueDAO = new PriorityQueueDAO();

    public static final Command[] commands = {
            new Add(),
            new Clear(),
            new Update(priorityQueueDAO),
            new Exit(),
            new Save(),
            new Show(),
            new RemoveById(),
    };
    /**
     * whichFunction - функция для работы с запросом пользователя
     */
    public static Organization whichFunction (int commandIndex, String fileName) throws EndException {
        Organization org = new Organization();
        AskIn ask = new AskIn();
        PriorityQueueDAO collection = new PriorityQueueDAO();
        Long id = 1L;
        switch (commandIndex){
            case 0:
                System.out.println("< Вызвана команда add >");
                org.setName(ask.askName(ih));
                org.setType(ask.askType(ih));
                org.setPostalAddress(ask.askPostalAddress(ih));
                org.setCoordinates(ask.askCoordinates(ih));
                org.setEmployeesCount(ask.askEmployeesCount(ih));
                org.setAnnualTurnover(ask.askAnnualTurnover(ih));
                org.setFullName(ask.askFullName(ih));
                break;
            case  1:
                System.out.println("< Вызвана команда clear >");
                break;
            case 2:
                System.out.println("< Вызвана команда update >");
                try{
                    id = ask.askId(ih);
                } catch (EndException e){
                    System.err.println(e.getMessage());
                }
                if (collection.get(id) != null){
                    try{
                    org.setId(id);
                    org.setName(ask.askName(ih));
                    org.setType(ask.askType(ih));
                    org.setPostalAddress(ask.askPostalAddress(ih));
                    org.setCoordinates(ask.askCoordinates(ih));
                    org.setEmployeesCount(ask.askEmployeesCount(ih));
                    org.setAnnualTurnover(ask.askAnnualTurnover(ih));
                    org.setFullName(ask.askFullName(ih));
                } catch (EndException e){
                        System.err.println(e.getMessage());
                    }
                } else {
                    System.err.println("Такого элемента нет!");
                }
                break;
            case 3:
                System.out.println("< Вызвана команда exit >");
                break;
            case 4:
                System.out.println("< Вызвана команда save >");
                priorityQueueDAO.saveCollectionToFile(fileName);

                break;
            case 5:
                System.out.println("< Вызвана команда show >");
                break;
            case 6:
                System.out.println("< Вызвана команда remove_by_id >");
                    try {
                        id = ask.askId(ih);
                    } catch (EndException e) {
                        System.err.println(e.getMessage());
                    }
                    if (collection.get(id) != null) {
                        collection.get(id).setId(id);
                        return collection.get(id);
                    } else {
                        System.err.println("Такого элемента нет!");
                    }
                break;
        }
        return org;
    }

    public static void whichCommand(String fileName) throws Exception{
        String command = null;
        String typeOfInput;
        System.out.println("Выбери файл(1) или консоль(2):");
       try {
            File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
            Scanner scForFile = new Scanner(file);
            Scanner scanner = new Scanner(System.in);
            typeOfInput = scanner.nextLine();

            if (!typeOfInput.isEmpty()){
                if (typeOfInput.equals("консоль")||typeOfInput.equals("2")) {
                    ih = new ConsoleInputHandler();
                    command = AskIn.askCommand(ih);
                } else if (typeOfInput.equals("файл")||typeOfInput.equals("1")){
                    ih = new FileInputHandler(scForFile);
                    if (!scForFile.hasNextLine()){
                        throw new IOException();
                    }
                } else {
                    throw new IllegalArgumentException("Некорректный ввод!");
                }
            } else {
                throw new IllegalArgumentException("Ты ввел пустоту!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            whichCommand(fileName);
            return;
        } catch (IOException exception){
            System.out.println("У тебя файл пустой!");
            whichCommand(fileName);
            return;
        }
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        Organization org = whichFunction(commandIndex, fileName);
        commands[commandIndex].execute(org);
        whichCommand(fileName);
        }
    }
