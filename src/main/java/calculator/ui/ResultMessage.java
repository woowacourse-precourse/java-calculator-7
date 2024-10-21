package calculator.ui;

public class ResultMessage {

    private final String prefix = "결과 : ";
    private final String result;

    public ResultMessage(final String result) {
        this.result = result;
    }

    String getResult() {
        return prefix + result;
    }
}
