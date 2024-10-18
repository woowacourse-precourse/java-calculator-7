package calculator.domain.collection;

import calculator.domain.value.Delimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = List.copyOf(delimiters);
    }

    public static Delimiters of(String input) {
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(","));
        delimiters.add(new Delimiter(":"));

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르게 입력되지 않았습니다.");
            }
            Delimiter customDelimiter = new Delimiter(input.substring(2, newlineIndex));
            delimiters.add(customDelimiter);
        }
        return new Delimiters(delimiters);
    }

    public String removeDelimiterDefinition(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            return input.substring(newlineIndex + 2);
        }
        return input;
    }

    public String[] split(String input) {
        String regex = delimiters.stream()
                .map(Delimiter::toRegex)
                .collect(Collectors.joining("|"));
        return input.split(regex);
    }
}
