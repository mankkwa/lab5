package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws IOException {

        CommandManager manager = new CommandManager();
        manager.whichCommand();

    }




}
