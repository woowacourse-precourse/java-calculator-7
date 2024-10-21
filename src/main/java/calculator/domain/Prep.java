package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Prep {

    public static List<String> dicedChunk(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter)).filter(s ->!s.isEmpty()).toList();
    }

    public static List<Long> convertToNumbers(List<String> dicedExpression) {
        return dicedExpression.stream().map(Long::parseLong).toList();
    }
}
