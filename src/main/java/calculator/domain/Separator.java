package calculator.domain;

public class Separator {
    private static final String defaultSeparator = "[,:]";
    private String customSeparator = "";

    public Separator(String inputValue) {
        setCustomSeparator(inputValue);
    }

    private void setCustomSeparator(String inputValue) {
        if (inputValue.startsWith("//")) {
            this.customSeparator = String.valueOf(inputValue.charAt(2));
        }
    }

    public String[] splitBySeparator(String inputValue) {
        if (customSeparator.isEmpty()) {
            return inputValue.split(defaultSeparator);
        }
        String targetValue = inputValue.substring(5);
        return targetValue.split(customSeparator);
    }
}
