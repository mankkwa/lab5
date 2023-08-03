package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;
import database.commands.Add;
import database.commands.Command;
import database.commands.Update;
import database.dao.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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

    public static void whichCommand() throws IOException {
        File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
        Scanner scForFile = new Scanner(file);
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number > 10) {
                ih = new ConsoleInputHandler();
            } else {
                ih = new FileInputHandler(scForFile);
            }
            System.out.println(ih.readInput());
        } catch (IOException e){
            System.err.print(e.getMessage());
            whichCommand();
            return;
        }
        whichCommand();
    }

}
