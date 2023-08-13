package client;

import client.CommandType;
import client.handlers.ConsoleInputHandler;
import client.handlers.InputHandler;
import models.Address;
import models.Coordinates;
import models.Location;
import models.OrganizationType;
import models.exceptions.EndException;



public class AskIn {
    public static boolean FRIEND_DETECTOR;

    public static boolean friendlyInterface() {
        System.out.println("You хочешь friendly интерфейс? Yes or нет?");
        ConsoleInputHandler cih = new ConsoleInputHandler();
        String answer = cih.readInput().toLowerCase();
        try {
            if (answer.equals("да") || answer.equals("yes")){
                FRIEND_DETECTOR = true;
            } else if (answer.equals("нет") || answer.equals("no")) {
                FRIEND_DETECTOR = false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ваш ответ некорректный!");
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
                        System.err.println("Такой команды не существует!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    command = null;
                } else if (command.equals("")) {
                    throw new RuntimeException("");
                } else {
                    throw new EndException("Непон что за команда, игнор...");
                }
            }
        }
        return command;
    }

    public Long askId(InputHandler ih) throws EndException {
        String inputId = null;

        while (inputId == null) {
            System.out.println("Введите id: ");
            try {
                inputId = ih.readInput();
                if (Integer.parseInt(inputId) <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputId.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputId = null;
                } else {
                    throw new RuntimeException("");
                }
            }
        }
        return Long.parseLong(inputId);
    }

    public String askName(InputHandler ih) throws EndException {
        String inputName = null;
        while (inputName == null) {
            System.out.println("Введите имя:");
            try {
                inputName = ih.readInput();
                if (inputName.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    System.err.println("Ты ввел пустоту!");
                    inputName = null;
                }else{
                    throw new EndException("Некорректный ввод поля!");
                }
            }
        }
        return inputName;
    }

    public Coordinates askCoordinates(InputHandler ih) throws EndException {
        System.out.println("< < Введите координаты > >");
        String inputCoordinates = null;

        while (inputCoordinates == null) {
            System.out.println("Введите координату x: ");
            try {
                inputCoordinates = ih.readInput();
                Double.parseDouble(inputCoordinates);
                if (Double.parseDouble(inputCoordinates) == 0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputCoordinates.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputCoordinates = null;
                } else if (inputCoordinates.equals("")) {
                    throw new RuntimeException("");
                }
            }
        }
        Double x = Double.parseDouble(inputCoordinates);
        inputCoordinates = null;

        while (inputCoordinates == null) {
            System.out.println("Введите координату y: ");
            try {
                inputCoordinates = ih.readInput();
                Long.parseLong(inputCoordinates);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputCoordinates.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputCoordinates = null;
                } else if (inputCoordinates.equals("")) {
                    throw new RuntimeException("");
                }
            }
        }
        Long y = Long.parseLong(inputCoordinates);

        return new Coordinates(x, y);
    }


    public Float askAnnualTurnover(InputHandler ih) throws EndException{
        String inputAnnualTurnover = null;
        while (inputAnnualTurnover == null) {
            System.out.println("Введите годовой оборот: ");
            try {
                inputAnnualTurnover = ih.readInput();
                if (Float.parseFloat(inputAnnualTurnover)<=0)throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputAnnualTurnover.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputAnnualTurnover = null;
                } else if (inputAnnualTurnover.equals("")){
                    throw new RuntimeException("");
                }
            }
        }
        return Float.parseFloat(inputAnnualTurnover);
    }

    public String askFullName(InputHandler ih) throws EndException{
        String inputFullName = null;
        while (inputFullName == null) {
            System.out.println("Введите полное имя: ");
            try {
                inputFullName = ih.readInput();
                if (inputFullName.isEmpty() || inputFullName.length()>1637) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputFullName.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputFullName = null;
                } else if (inputFullName.equals("")){
                    throw new RuntimeException("");
                }
            }
        }
        return inputFullName;
    }

    public Integer askEmployeesCount(InputHandler ih) throws EndException{
        String inputEmployeesCount = null;
        while (inputEmployeesCount == null) {
            System.out.println("Введите количество сотрудников: ");
            try {
                inputEmployeesCount = ih.readInput();
                if (Integer.parseInt(inputEmployeesCount)<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputEmployeesCount.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputEmployeesCount = null;
                } else if (inputEmployeesCount.equals("")){
                    throw new RuntimeException("");
                }
            }
        }
        return Integer.parseInt(inputEmployeesCount);
    }

    public OrganizationType askType(InputHandler ih) throws EndException{
        String inputOrgType = null;
        while (inputOrgType == null) {
            System.out.println("Введите тип организации: ");
            try {
                inputOrgType = ih.readInput();
                if (inputOrgType.isEmpty()) throw new NumberFormatException();
                OrganizationType.valueOf(inputOrgType.toUpperCase());
            } catch (NumberFormatException e){
                System.err.println("Вы ввели пустую строку. Поле примет значение null.");
                return null;
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    System.err.println("Некорректный ввод поля!");
                    inputOrgType = null;
                } else if (inputOrgType.equals("")){
                    throw new RuntimeException("");
                }
            }
        }
        return OrganizationType.valueOf(inputOrgType.toUpperCase());
    }

    public Address askPostalAddress(InputHandler ih) throws EndException{
        System.out.println("< < Введите адрес организации > >");
        String inputPostalAddress = null;
        String street;
        while (inputPostalAddress == null) {
            System.out.println("Введите улицу: ");
            try {
                inputPostalAddress = ih.readInput();
                if (inputPostalAddress.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустое поле!");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")){
                    throw new RuntimeException("");
                }
            }
        }
        street = inputPostalAddress;
        inputPostalAddress = null;

        System.out.println("< < Введите местоположение города > >");
        while (inputPostalAddress == null) {
            System.out.println("Введите координату x: ");
            try {
                inputPostalAddress = ih.readInput();
                Double.parseDouble(inputPostalAddress);
                if (Double.parseDouble(inputPostalAddress)==0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
            }
        }
        Double x = Double.parseDouble(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.println("Введите координату y: ");
            try {
                inputPostalAddress = ih.readInput();
                Float.parseFloat(inputPostalAddress);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
            }
        }
        Float y = Float.parseFloat(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.println("Введите координату z: ");
            try {
                inputPostalAddress = ih.readInput();
                Long.parseLong(inputPostalAddress);
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!\n");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
            }
            }
        Long z = Long.parseLong(inputPostalAddress);
        inputPostalAddress = null;

        while (inputPostalAddress==null){
            System.out.println("Введите название локации: ");
            try {
                inputPostalAddress = ih.readInput();
                if (inputPostalAddress.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if (FRIEND_DETECTOR && ih.getClass() == ConsoleInputHandler.class) {
                    if (!inputPostalAddress.isEmpty()) {
                        System.err.println("Некорректный ввод поля!");
                    } else {
                        System.err.println("Ты ввел пустоту!");
                    }
                    inputPostalAddress = null;
                } else if (inputPostalAddress.equals("")) {
                    throw new RuntimeException("");
                }
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


