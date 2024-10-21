package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {

    private final List<String> delimiters;

    public Delimiter() {
        delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
    }

    public void add(String delimiter) {
        delimiters.add(delimiter);
    }

    @Override
    public String toString() {
        return delimiters.stream()
                .map(Pattern::quote) // 특수 문자 이스케이프 처리
                .reduce((a, b) -> a + "|" + b)
                .orElse("");
    }
}
