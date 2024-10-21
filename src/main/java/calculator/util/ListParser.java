package calculator.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListParser {
    public static List<Long> parseStringsToLongs(List<String> inputList) {
        try {
            return inputList.stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 있거나 빈 문자열이 있습니다.");
        }
    }

    private ListParser() {
    }
}
