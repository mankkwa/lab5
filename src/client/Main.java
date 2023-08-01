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

        ConsoleInputHandler cih = new ConsoleInputHandler();
        //System.out.println(cih.readInput());

        File file = new File("C:\\Users\\mankk\\Учеба\\2 семестр\\lab5\\src\\m.txt");
        Scanner scForFile = new Scanner(file);
        FileInputHandler fih = new FileInputHandler(scForFile);
        //System.out.println(fih.readInput());

        InputHandler ih = new ConsoleInputHandler();

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number>10){
            ih = new ConsoleInputHandler();
        } else{
            ih = new FileInputHandler(scForFile);
        }
        System.out.println(ih.readInput());

    }




}
