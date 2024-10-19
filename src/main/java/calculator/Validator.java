package calculator;

public class Validator {
    private String input;

    public Validator(String input) {
        this.input = input;
    }

    public void validateInput() {
        if (isEmptyString()) {
            return;
        }
        if (isInvalidCharacter()) {
            throw new IllegalArgumentException("잘못된 문자 포함됨");
        }
        if (isNegativeNumber()) {
            throw new IllegalArgumentException("양수만 입력 가능");
        }
    }

    private boolean isNegativeNumber() {
        return input.contains("-");
    }

    private boolean isEmptyString() {
        return input.isEmpty();
    }

    private boolean isInvalidCharacter() {
        for (char c : input.toCharArray()) {
            if (!validateCharacter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateCharacter(char c) {
        return Character.isDigit(c) || Delimiter.delimiter.indexOf(c) != -1;
    }
}
