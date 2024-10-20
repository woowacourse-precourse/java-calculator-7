package calculator.view;

public class ResponseView {

    private static final ResponseView INSTANCE = new ResponseView();
    private static final String OUTPUT_MESSAGE_FORMAT = "결과 : %d";

    private ResponseView() {
    }

    public static ResponseView getInstance() {
        return INSTANCE;
    }

    public void print(final int result) {
        System.out.printf(OUTPUT_MESSAGE_FORMAT, result);
    }
}
