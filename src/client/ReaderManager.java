package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс для обработки команды и ее взаимодействия с входными данными
 */
public class ReaderManager {
    private static InputHandler reader;
    private static ArrayList<InputHandler> handlers = new ArrayList<>();

    public static InputHandler getReader() {
        return reader;
    }

    public static void removeLast() {
        handlers.remove(handlers.size() - 1);
    }

    public static void turnOnConsole() {
        reader = new ConsoleInputHandler();
        handlers.add(reader);
    }

    public static void returnOnPreviousReader() {
        reader = handlers.get(handlers.size() - 1);
    }

    //метод для смены на чтение из файла
}
