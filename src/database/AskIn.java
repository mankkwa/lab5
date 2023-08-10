package database;

import client.CommandType;
import client.handlers.ConsoleInputHandler;
import client.handlers.InputHandler;
import models.Address;
import models.Coordinates;
import models.Location;
import models.OrganizationType;
import models.exceptions.EndException;

import java.io.IOException;
import java.util.Locale;


public class AskIn {
    public static boolean FRIEND_DETECTOR;

    public static boolean friendlyInterface() {
        System.out.println("You хочешь friendly интерфейс? Yes or нет?");
        ConsoleInputHandler cih = new ConsoleInputHandler();
        String answer = cih.readInput().toLowerCase();
        try {
            if (answer.equals("да")) {
                FRIEND_DETECTOR = true;
            } else if (answer.equals("нет")) {
                FRIEND_DETECTOR = false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Это ты что написал брат");
            friendlyInterface();
        }
        return FRIEND_DETECTOR;
    }


    public static String askCommand(InputHandler ih) throws EndException {
        String command = null;
        while (command == null) {
            printMessage(ih, "Введите команду: ");
            try {
                command = ih.readInput();
                CommandType.valueOf(command.toUpperCase()).ordinal();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!command.isEmpty()) {
                        System.err.println("Такой команды не существует!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    command = null;
                } else if (command.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Непон что за команда, игнор...\n");
                }
            }
        }
        return command;
    }

    public int askId(InputHandler ih) throws EndException {
        String inputId = null;
        while (inputId == null) {
            System.out.print("Введите id: ");
            try {
                inputId = ih.readInput();
                if (Integer.parseInt(inputId) <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputId.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputId = null;
                } else {
                    throw new RuntimeException("");
                }
            }
        }
        return Integer.parseInt(inputId);
    }

    public String askName(InputHandler ih) throws EndException {
        String inputName = null;
        while (inputName == null) {
            System.out.print("Введите имя:");
            try {
                inputName = ih.readInput();
                if (inputName.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    System.err.println("Ты ввел пустоту!\n");
                    inputName = null;
                }else{
                    throw new EndException("Некорректный ввод поля!\n");
                }
            }
        }
        return inputName;
    }

    public Coordinates askCoordinates(InputHandler ih) throws EndException {
        System.out.print("< < Введите координаты > >");
        String inputCoordinates = null;

        while (inputCoordinates == null) {
            System.out.print("Введите координату x: ");
            try {
                inputCoordinates = ih.readInput();
                Double.parseDouble(inputCoordinates);
                if (Double.parseDouble(inputCoordinates) == 0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputCoordinates.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputCoordinates = null;
                } else if (inputCoordinates.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Не могу прочитать данные в файле...\n");
                }
            }
        }
        Double x = Double.parseDouble(inputCoordinates);
        inputCoordinates = null;

        while (inputCoordinates == null) {
            System.out.print("Введите координату y: ");
            try {
                inputCoordinates = ih.readInput();
                Long.parseLong(inputCoordinates);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputCoordinates.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputCoordinates = null;
                } else if (inputCoordinates.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Не могу прочитать данные в файле...\n");
                }
            }
        }
        Long y = Long.parseLong(inputCoordinates);

        return new Coordinates(x, y);
    }


    public Float askAnnualTurnover(InputHandler ih) throws EndException{
        String inputAnnualTurnover = null;
        while (inputAnnualTurnover == null) {
            System.out.print("Введите годовой оборот: ");
            try {
                inputAnnualTurnover = ih.readInput();
                if (Float.parseFloat(inputAnnualTurnover)<=0)throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputAnnualTurnover.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputAnnualTurnover = null;
                } else if (inputAnnualTurnover.equals("")){
                    throw new RuntimeException("");
                } else{
                    throw new EndException ("Не могу прочитать данные в файле...\n");
                }
            }
        }
        return Float.parseFloat(inputAnnualTurnover);
    }

    public String askFullName(InputHandler ih) throws EndException{
        String inputFullName = null;
        while (inputFullName == null) {
            System.out.print("Введите полное имя: ");
            try {
                inputFullName = ih.readInput();
                if (inputFullName.isEmpty() || inputFullName.length()>1637) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputFullName.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputFullName = null;
                } else if (inputFullName.equals("")){
                    throw new RuntimeException("");
                } else{
                    throw new EndException ("Не могу прочитать данные в файле...\n");
                }
            }
        }
        return inputFullName;
    }

    public Integer askEmployeesCount(InputHandler ih) throws EndException{
        String inputEmployeesCount = null;
        while (inputEmployeesCount == null) {
            System.out.print("Введите количество сотрудников: ");
            try {
                inputEmployeesCount = ih.readInput();
                if (Integer.parseInt(inputEmployeesCount)<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputEmployeesCount.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputEmployeesCount = null;
                } else if (inputEmployeesCount.equals("")){
                    throw new RuntimeException("");
                } else{
                    throw new EndException ("Не могу прочитать данные в файле...\n");
                }
            }
        }
        return Integer.parseInt(inputEmployeesCount);
    }

    public OrganizationType askType(InputHandler ih) throws EndException{
        String inputOrgType = null;
        while (inputOrgType == null) {
            System.out.print("Введите тип организации: ");
            try {
                inputOrgType = ih.readInput();
                if (inputOrgType.isEmpty()) throw new NumberFormatException();
                OrganizationType.valueOf(inputOrgType.toUpperCase());
            }catch (NumberFormatException e){
                System.err.println("Ты ввел пустое поле!\n");
                return null;
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    System.err.println("Некорректный ввод поля!\n");
                    inputOrgType = null;
                } else if (inputOrgType.equals("")){
                    throw new RuntimeException("");
                } else{
                    throw new EndException ("Не могу прочитать данные в файле...\n");
                }
            }
        }
        return OrganizationType.valueOf(inputOrgType.toUpperCase());
    }

    public Address askPostalAddress(InputHandler ih) throws EndException{
        System.out.println("< < Введите адрес организации > >");
        String inputPostalAddress = null;
        String street = null;
        while (inputPostalAddress == null) {
            printMessage(ih, "Введите улицу: ");
            try {
                inputPostalAddress = ih.readInput();
                street = inputPostalAddress;
                if (street.isEmpty()) throw new NumberFormatException();
            }catch (NumberFormatException e){
                System.err.println("Ты ввел пустое поле!\n");
                return null;
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    System.err.println("Некорректный ввод поля!\n");
                    street = null;
                } else if (street.equals("")){
                    throw new RuntimeException("");
                } else{
                    throw new EndException ("Не могу прочитать данные в файле...\n");
                }
            }
        }
        inputPostalAddress = null;

        System.out.println("< < Введите город > >");
        while (inputPostalAddress == null) {
            System.out.print("Введите координату x: ");
            try {
                inputPostalAddress = ih.readInput();
                Double.parseDouble(inputPostalAddress);
                if (Double.parseDouble(inputPostalAddress)==0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Не могу прочитать данные в файле...\n");
                }
            }
        }
        Double x = Double.parseDouble(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.print("Введите координату y: ");
            try {
                inputPostalAddress = ih.readInput();
                Float.parseFloat(inputPostalAddress);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Не могу прочитать данные в файле...\n");
                }
            }
        }
        Float y = Float.parseFloat(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.print("Введите координату z: ");
            try {
                inputPostalAddress = ih.readInput();
                Long.parseLong(inputPostalAddress);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
            } catch (Exception e){
                    throw new EndException("Не могу прочитать данные в файле...\n");
                }
            }
        Long z = Long.parseLong(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.print("Введите название локации: ");
            try {
                inputPostalAddress = ih.readInput();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!\n");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
            } catch (Exception e){
                throw new EndException("Не могу прочитать данные в файле...\n");
            }
        }
        String name = inputPostalAddress;
        Location town = new Location(x, y, z, name);
        return new Address(street, town);
    }

    private static void printMessage(InputHandler in, String message) {
            System.out.println(message);
        }
    }


