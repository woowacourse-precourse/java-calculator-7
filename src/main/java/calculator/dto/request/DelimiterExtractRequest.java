package calculator.dto.request;

public class DelimiterExtractRequest {
    private final String input;

    public DelimiterExtractRequest(String input){
        this.input = input;
    }

    public String getInput() {
        return input;
    }

}
