package database.commands;

import java.util.List;
import java.util.Locale;

public interface Command {
    void execute(List<Object> args);
    List<Class> getArgsType();

    default String name(){
        return getClass().getSimpleName().toLowerCase(Locale.getDefault());
    }
}
