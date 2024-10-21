package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {
    private String input;
    private String delimiter = "[,:]";

    public InputProcessor(String input) {
        this.input = input;
        checkCustomDelimiter();
        validateInput();
    }

    private void checkCustomDelimiter() {
        if (input.startsWith("//")) {
            customDelimiter();
        }
    }

    private void customDelimiter(){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        delimiter = matcher.group(1);
        input = matcher.group(2);
    }

    private void validateInput() {
        checkInputNotNull();

    }

    private void checkInputNotNull(){
        if (input.isEmpty()) {
            input = String.valueOf(0);
        }
    }
}
