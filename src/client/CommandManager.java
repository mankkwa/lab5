package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;
import database.commands.Add;
import database.commands.Command;
import database.commands.Update;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Перечисление существующих команд
 */
enum CommandType {
    ADD,
    CLEAR,
    UPDATE;
}

/**
 * Класс для работы с командами
 */
public class CommandManager {

    private static InputHandler ih;

    public static final Command[] commands = {
            new Add(),
            new Update(),

    };

    public static void whichCommand() {
        System.out.println("Введи что-нибудь чел блин:");
        String typeOfInput;
        try {
            File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
            Scanner scForFile = new Scanner(file);
            Scanner scanner = new Scanner(System.in);
            typeOfInput = scanner.nextLine();
            if (!typeOfInput.isEmpty()){
                if (typeOfInput.equals("консоль")) {
                    ih = new ConsoleInputHandler();
                } else if (typeOfInput.equals("файл")){
                    ih = new FileInputHandler(scForFile);
                    if (!scForFile.hasNextLine()){
                        throw new IOException();
                    }
                } else {
                    throw new IllegalArgumentException("то, что ты ввел - лютый кринжd\n");
                }
            } else {
                throw new IllegalArgumentException("этой строки нет как и твоей совести\n");
            }
            System.out.println(ih.readInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException exception){
            System.out.println("у тебя файл пустой чел!\n");
        }
        whichCommand();
        }
    }
