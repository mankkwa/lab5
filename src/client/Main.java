package client;

import client.handlers.ConsoleInputHandler;
import client.handlers.FileInputHandler;
import client.handlers.InputHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleInputHandler cih = new ConsoleInputHandler();
        //System.out.println(cih.readInput());

        File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
        Scanner sc = new Scanner(file);
        FileInputHandler fih = new FileInputHandler(sc);
        System.out.println(fih.readInput());


    }
}
