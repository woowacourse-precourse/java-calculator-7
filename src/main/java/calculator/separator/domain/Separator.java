package calculator.separator.domain;

public class CustomSeparator {
    private final String customSeparator;
    public CustomSeparator(String customSeparator) {
        System.out.println("sep: "  + customSeparator);
        this.customSeparator = customSeparator;
    }
    public String getCustomSeparator() {
        return customSeparator;
    }
    public boolean isBlank() {
        return customSeparator.isBlank();
    }

}
