package calculator.dto;

public class CheckSeparatorDto {
    private String inputString;
    private String customSeparator = null;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }

    public void setCustomSeparator(String customSeparator) {
        this.customSeparator = customSeparator;
    }
}
