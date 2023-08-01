package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.InputHandler;

public class Main {
    public static void main(String[] args) {

        ConsoleInputHandler cih = new ConsoleInputHandler();
        System.out.println(cih.readInput());

    }
}
