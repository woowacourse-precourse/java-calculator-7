package calculator.dto;

public class InputRequest {
    private final String delimiters;
    private final String targetInput;

    public InputRequest(String delimiters, String targetInput) {
        this.delimiters = delimiters;
        this.targetInput = targetInput;
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String getTargetInput() {
        return targetInput;
    }

    public static InputRequest of(String delimiters, String targetInput) {
        return new InputRequest(delimiters, targetInput);
    }
}
