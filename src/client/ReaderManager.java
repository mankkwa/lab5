package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReaderManager {
    private static InputHandler handler;
    private static final ArrayList<InputHandler> handlers = new ArrayList<>();

    public static InputHandler getHandler() {
        return handler;
    }

    public static void turnOnConsole() {
        // новый экземпляр класса считывания
        handler = new ConsoleInputHandler();
        // добавляем в массив хендлеров, чтобы потом к нему вернуться
        handlers.add(handler);
        // Возврат к дружественному интерфейсу после считывания с файла, если оно было
        AskIn.returnFriendly();
    }

    public static void removeLast() {
        handlers.remove(handlers.size() - 1);
    }

    public static void returnOnPreviousReader() {
        handler = handlers.get(handlers.size()-1);
        AskIn.returnFriendly();
    }

    public static void turnOnFile(BufferedInputStream reader) {
        handler = new FileInputHandler(reader);
        handlers.add(handler);
        AskIn.turnOffFriendly();
    }

}
