package calculator.validator;

import java.util.List;

public class ListValidator {
    private ListValidator() {}

    public static void validatePositiveNumberList(List<Long> list) throws IllegalArgumentException{
        list.forEach(l -> {
            if (l <= 0) throw new IllegalArgumentException();
        });
    }
}
