package calculator.dto.request;

public class ConverterRequest {
    private final String delimiter;
    private final String remainInput;

    public ConverterRequest(String delimiter, String remainInput) {
        this.delimiter = delimiter;
        this.remainInput = remainInput;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getRemainInput() {
        return remainInput;
    }
}
