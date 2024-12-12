package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.Exception;

public class Coachs {
    private List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
        validateCoachAmount(coachs);
        this.coachs = coachs;
    }

    public void recommendMenuOneCycle(String category) {
        for (Coach coach : coachs) {
            recommendMenu(coach, category);
        }
    }

    public List<String> getCoachNames() {
        List<String> coachNames = new ArrayList<>();
        for (Coach coach : coachs) {
            coachNames.add(coach.getName());
        }
        return coachNames;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

    private void recommendMenu(Coach coach, String category) {
        try {
            String menu = Menu.recommendationMenu(category);
            validateMenuIsInedible(coach, menu);
            coach.addRecommendMenu(menu);
        } catch (IllegalArgumentException e) {
            recommendMenu(coach, category);
        }
    }

    private void validateMenuIsInedible(Coach coach, String menu) {
        if (coach.getInedibleMenu().isEdibleMenu(menu)) {
            throw new IllegalArgumentException(Exception.ERROR);
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