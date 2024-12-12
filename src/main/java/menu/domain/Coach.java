package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private List<String> menus;
    private List<String> inedibles;

    public Coach(String name, List<String> menus, List<String> inedibles) {
        this.name = name;
    }
}
