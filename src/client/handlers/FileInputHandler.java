package client.handlers;

import java.io.IOException;
import java.util.Scanner;

public class FileInputHandler extends InputHandler{
    private final Scanner scanner;

    public FileInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readInput() throws IOException {
        return null;
    }
}
