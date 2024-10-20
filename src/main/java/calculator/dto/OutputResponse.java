package calculator.dto;

public class OutputResponse {
    private final int result;

    public OutputResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public static OutputResponse of(int result) {
        return new OutputResponse(result);
    }
}

