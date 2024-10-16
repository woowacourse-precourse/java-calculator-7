package calculator.domain.model;

public class ExtractedInput {
    private final String delimiters;
    private final String remainingInput;

    private ExtractedInput(String delimiters, String remainingInput) {
        this.delimiters = delimiters;
        this.remainingInput = remainingInput;
    }

    public static ExtractedInput of(String delimiters, String remainingInput) {
        return new ExtractedInput(delimiters, remainingInput);
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String getRemainingInput() {
        return remainingInput;
    }
}
