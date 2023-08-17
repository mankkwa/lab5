package database;

import client.Main;
import com.google.gson.Gson;
import models.Organization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileManager {
    private static final Gson gson = new Gson();

    public static void writeCollection(Collection<Organization> data, String output){
        try (FileWriter writer = new FileWriter(output)) {
            writer.write(gson.toJson(data));
            writer.close();
            System.out.println("Коллекция сохранена: " + output);
        } catch (IOException e) {
            System.err.println("погчамп ошибка");
        }
    }

}
