package calculator.entity;

import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_END;
import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_LENGTH;

public class Input {

    protected final String input;

    public Input(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input should not be null");
        }
        this.input = input;
    }

    public Integer length() {
        return input.length();
    }

    public boolean isCustomSep(Index index) {
        if (!input.startsWith("//", index.value)) {
            return false;
        }

        return input.startsWith("\\n", index.value + CUSTOM_SEPARATOR_END);
    }

    public String oneLetter(Index index) {
        char charLetter = input.charAt(index.value);
        return String.valueOf(charLetter);
    }

    public Index maxSepStringIdx() {
        return new Index(input.length() - CUSTOM_SEPARATOR_LENGTH);
    }

    public Index maxIdx() {
        return new Index(input.length());
    }

}
