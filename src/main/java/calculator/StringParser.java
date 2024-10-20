package calculator;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class StringParser {
    private final Set<Character> delimiters;
    private String processedInput;

    public StringParser(String input, Set<Character> defaultDelimiters) {
        this.delimiters = new HashSet<>(defaultDelimiters);
        processInput(input);
        validateInput();
    }

    private void processInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        if (!input.startsWith("//")) {
            processedInput = input;
            return;
        }

        int newLineIndex = input.indexOf("\\n");

        if (newLineIndex != 3) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        delimiters.add(input.charAt(2));
        processedInput = input.substring(newLineIndex + 2);
    }

    private void validateInput() {
        // 구분자들을 하나의 문자열로 합침
        String delimiterString = delimiters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String validChars = "[0-9" + delimiterString + "]*";
        if (!processedInput.matches("^" + validChars + "$")) {
            throw new IllegalArgumentException("입력값에 허용되지 않는 문자가 포함되어 있습니다.");
        }
    }

    public Set<Character> getDelimiters() {
        return new HashSet<>(delimiters);
    }

    public String getProcessedInput() {
        return processedInput;
    }
}