package client;

import database.commands.Add;
import database.commands.Command;
import database.commands.Update;
import database.dao.*;

/**
 * Перечисление существующих команд
 */
enum CommandType {
    ADD,
    CLEAR,
    UPDATE;
}

public class CommandManager {

    public static final Command[] commands = {
            new Add(),
            new Update(),
            new Update(),
    };

    public static void whichCommand(){
        String command;

    }

}
