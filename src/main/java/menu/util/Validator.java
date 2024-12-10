package menu.util;

import java.util.List;

public class Validator {
    public static void validateCoach(String[] coachs) {
        validateNameLength(coachs);
        validateCoachAmount(coachs);
    }

    public static void validateNameLength(String[] coachs) {
        for (String coach : coachs) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_NAME_LENGTH);
            }
        }
    }

    public static void validateCoachAmount(String[] coachs) {
        if (coachs.length < 2 || coachs.length > 5) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.COACH_AMOUNT);
        }
    }

    public static void validateCategory(String category) {

    }

    public static void validateInedible(String[] inedible) {

    }
}
