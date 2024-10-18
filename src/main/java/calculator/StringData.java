package calculator;

public class StringData {
    private String inputString;
    private String separator;
    private boolean hasCustomSeparator;

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    public void setHasCustomSeparator(boolean hasCustomSeparator) {
        this.hasCustomSeparator = hasCustomSeparator;
    }

    public boolean getHasCustomSeparator() {
        return hasCustomSeparator;
    }
}