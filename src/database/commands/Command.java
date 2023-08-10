package database.commands;

import models.exceptions.EndException;

import java.util.List;
import java.util.Locale;

/**
 * интерфейс команд
 */
public interface Command {
    void execute(Object obj) throws EndException;
    List<Class> getArgsType();

    default String name(){
        return getClass().getSimpleName().toLowerCase(Locale.getDefault());
    }

}
