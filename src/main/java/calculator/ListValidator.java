package calculator;

import java.util.List;

public class ListValidator {

    public static void validateIsPosList(List<Long> list) throws IllegalStateException{
        for (Long i : list) {
            if(i <= 0) throw new IllegalStateException();
        }
    }
}
