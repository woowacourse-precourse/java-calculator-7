package calculator.entity;


import static calculator.utils.Constants.CUSTOM_SEPARATOR_LENGTH;

public class Input {

    protected final String value;

    public Input(String value) {
        this.value = value;
    }

    public Integer length() {
        return value.length();
    }

    public boolean isCustomSep(Index index) {

        if (!index.isStartCustomSep(value)) {
            return false;
        }

        return index.isEndCustomSep(value);
    }

    protected String oneLetter(Index index) {
        return index.oneLetter(value);
    }

    public Index maxSepStringIdx() {
        Index index = new Index(value.length());
        return index.minus(CUSTOM_SEPARATOR_LENGTH);
    }

    public Index maxIdx() {
        return new Index(value.length());
    }

    public Separator toSeparatorByIndex(Index index) {
        return new Separator(oneLetter(index));
    }

}
