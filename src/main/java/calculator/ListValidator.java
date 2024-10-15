package calculator;

import java.util.List;

public class ListValidator {
    private ListValidator() {}

    public static void validateIsPosList(List<Long> list) throws IllegalArgumentException{
        for (Long i : list) {
            if(i <= 0) throw new IllegalArgumentException();
        }
    }
}
