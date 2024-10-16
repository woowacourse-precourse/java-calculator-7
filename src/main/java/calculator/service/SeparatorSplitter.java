package calculator.service;

import java.util.List;

public class SeparatorSplitter {

    private final List<String> separators;
    private final String input;

    public SeparatorSplitter(List<String> separators, String input) {
        if (separators == null || separators.isEmpty()) {
            throw new IllegalArgumentException("구분자 목록이 존재하지 않습니다.");
        }
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        this.separators = separators;
        this.input = input;
    }

    public String[] split() {
        String regex = String.join("|", separators);
        return input.split(regex);
    }
}
