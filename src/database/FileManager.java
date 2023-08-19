package database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Organization;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final Gson gson = new Gson();

    public static void writeCollection(Collection<Organization> data, String output) {
        if (output != null) {
            try (OutputStreamWriter writer = new FileWriter(output)) {
                writer.write(gson.toJson(data));
                writer.close();
                System.out.println("Коллекция сохранена: " + output);
            } catch (IOException e) {
                System.err.println("Файл не может быть открыт.");
            }
        } else System.err.println("Данный файл не найден!");
    }

    public static PriorityQueue<Organization> readCollection(String input){
        if (input != null) {
            try (Scanner reader = new Scanner(input)) {
                PriorityQueue<Organization> collection;
                //Здесь я использовала класс библиотеки TypeToken
                //Сначала определила желаемый тип коллекции
                TypeToken<PriorityQueue<Organization>> typeToken = new TypeToken<PriorityQueue<Organization>>() {};
                //Далее получаем тип коллекции при помощи .getType(), используя уже выше определенный typeToken
                java.lang.reflect.Type collectionType = typeToken.getType();
                //затем здесь происходит десериализация в коллекцию при помощи fromJson
                collection = gson.fromJson(reader.nextLine(), collectionType);
                System.out.println("Коллекция загружена!");
                return collection;
            } //catch (FileNotFoundException exception) {
               // System.err.println("Файл не найден! Коллекция будет создана автоматически.");}
            catch (NoSuchElementException exception) {
                System.err.println("Файл пуст!");
            }
        } else System.err.println("Данный файл не найден!");
        return new PriorityQueue<>();
    }
}
