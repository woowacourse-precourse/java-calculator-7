package menu.domain;

import java.util.List;
import menu.util.Exception;

public class Coachs {
    private List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
        validateCoachAmount(coachs);
        this.coachs = coachs;
    }

    public void recommendMenuOneCycle() {
        String category = Menu.randomCategory();
        for (Coach coach : coachs) {
            recommendMenu(coach, category);
        }
    }

    private void recommendMenu(Coach coach, String category) {
        while (true) {
            try {
                coach.addRecommendMenu(Menu.recommendationMenu(category));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateCoachAmount(List<Coach> coachs) {
        if (coachs.size() < 2) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_AMOUNT_UNDER_RANGE);
        }
        if (coachs.size() > 5) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_AMOUNT_OVER_RANGE);
        }
    }
}