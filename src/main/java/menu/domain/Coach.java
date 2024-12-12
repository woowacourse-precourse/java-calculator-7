package menu.domain;

import menu.util.Exception;

public class Coach {
    private final String name;
    private InedibleMenu inedibleMenu;
    private RecommendMenu recommendMenu;

    public Coach(String name, InedibleMenu inedibleMenu, RecommendMenu recommendMenu) {
        validateNameLength(name);
        this.name = name;
        this.inedibleMenu = inedibleMenu;
        this.recommendMenu = recommendMenu;
    }

    public void addRecommendMenu(String menu) {
        recommendMenu.addRecommendMenu(menu);
    }

    public String getName() {
        return name;
    }

    public RecommendMenu getRecommendMenu() {
        return recommendMenu;
    }

    public InedibleMenu getInedibleMenu() {
        return inedibleMenu;
    }

    private void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_NAME_LENGTH);
        }
    }
}
