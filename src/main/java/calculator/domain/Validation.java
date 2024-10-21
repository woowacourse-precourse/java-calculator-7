package calculator.domain;

import java.util.List;

public class Validation {

    public static void undefinedStrMixedInExpression (String unified, List<String> delimiters) {
        List<String> chars = List.of(unified.split(""));
        if(chars.stream()
                .filter(s -> s.matches("[0-9]")).count()
                + chars.stream()
                .filter(s -> s.matches(delimiters.getFirst())).count()
                != chars.size())
            throw new IllegalArgumentException();
    }

    public static void overTheLongRangeNumberElements (List<Long> numbers) {
        for (Long number : numbers) {
            if(overflowOutbreak(number)) throw new IllegalArgumentException();
        }
    }

    public static void overflowOccurInLongValue(Long value) {
        if(overflowOutbreak(value)) throw new IllegalArgumentException();
    }

    private static Boolean overflowOutbreak(Long value) {
        return value < 0;
    }

}
