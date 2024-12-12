package menu.domain;

import java.util.List;
import menu.util.Exception;

public class Coach {
    private final String name;
    private List<String> menus;
    private List<String> inedibles;

    public Coach(String name, List<String> menus, List<String> inedibles) {
        validateNameLength(name);
        this.name = name;
    }

    public void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_NAME_LENGTH);
        }
    }
}
