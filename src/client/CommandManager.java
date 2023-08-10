package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;
import database.AskIn;
import database.commands.Add;
import database.commands.Clear;
import database.commands.Command;
import database.commands.Update;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для работы с командами
 */
public class CommandManager {

    private static InputHandler ih;


    public static final Command[] commands = {
            new Add(),
            new Clear(),
            new Update(),
    };

    public static void whichCommand() throws Exception{
        System.out.println("Введи что-нибудь чел блин:");
        String command = null;
        String typeOfInput;
       try {
            File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
            Scanner scForFile = new Scanner(file);
            Scanner scanner = new Scanner(System.in);
            typeOfInput = scanner.nextLine();

            if (!typeOfInput.isEmpty()){
                if (typeOfInput.equals("консоль")) {
                    ih = new ConsoleInputHandler();
                    command = AskIn.askCommand(ih);
                } else if (typeOfInput.equals("файл")){
                    ih = new FileInputHandler(scForFile);
                    if (!scForFile.hasNextLine()){
                        throw new IOException();
                    }
                } else {
                    throw new IllegalArgumentException("то, что ты ввел - лютый кринж");
                }
            } else {
                throw new IllegalArgumentException("этой строки нет как и твоей совести");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            whichCommand();
            return;
        } catch (IOException exception){
            System.out.println("у тебя файл пустой чел!");
            whichCommand();
            return;
        }
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        Add add = new Add();
        commands[commandIndex].execute(add);
        whichCommand();
        }
    }
