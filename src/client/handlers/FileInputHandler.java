package client.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInputHandler extends InputHandler {
    private final Scanner scanner;

    public FileInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readInput() throws IOException {
        String line = "";
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                //.trim() осуществляет обрезание пробелов
            }

        } finally {
            scanner.close();
        }
        return line;
    }
}
