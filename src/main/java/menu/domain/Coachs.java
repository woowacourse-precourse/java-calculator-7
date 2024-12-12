package menu.domain;

import java.util.List;
import menu.util.Exception;

public class Coachs {
    private List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
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
