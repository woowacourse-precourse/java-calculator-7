package calculator.entity;

import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_END;
import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_LENGTH;

public class Input {

    protected final String value;

    public Input(String value) {
        this.value = value;
    }

    public Integer length() {
        return value.length();
    }

    public boolean isCustomSep(Index index) {
        if (!value.startsWith("//", index.value)) {
            return false;
        }

        return value.startsWith("\\n", index.value + CUSTOM_SEPARATOR_END);
    }

    public Separator toSeparatorByIndex(Index index) {
        return new Separator(oneLetter(index));
    }

    protected String oneLetter(Index index) {
        char charLetter = value.charAt(index.value);
        return String.valueOf(charLetter);
    }

    public Index maxSepStringIdx() {

        return new Index(value.length() - CUSTOM_SEPARATOR_LENGTH);
    }

    public Index maxIdx() {
        return new Index(value.length());
    }

}
