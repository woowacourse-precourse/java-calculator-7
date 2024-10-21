package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {
    private String input;
    private String delimiter = "[,:]";

    public InputProcessor(String input) {
        this.input = input.trim();
        checkCustomDelimiter();
        validateInput();
    }

    private void checkCustomDelimiter() {
        if (input.startsWith("//")) {
            customDelimiter();
        }
    }

    private void customDelimiter() {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        delimiter = Pattern.quote(matcher.group(1));
        input = matcher.group(2);
    }

    private void validateInput() {
        checkInputNotEmpty();
        validateNumbers();
    }

    private void checkInputNotEmpty() {
        if (input.isEmpty()) {
            input = "0";
        }
    }

    private void validateNumbers() {
        if (!input.matches("[0-9" + delimiter + "]*")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 숫자와 구분자로만 이루어져야 합니다.");
        }

        if (input.matches(".*-[0-9].*")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        if (input.matches(".*" + delimiter + "{2,}.*")) {
            throw new IllegalArgumentException("구분자가 연속해서 올 수 없습니다.");
        }
    }

    public String[] splitNumbers() {
        return input.split(delimiter);
    }
}
