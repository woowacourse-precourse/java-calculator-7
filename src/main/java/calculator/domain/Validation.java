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
}
