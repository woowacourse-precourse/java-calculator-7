package calculator.view;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "결과 : ";

    public void showOutputMessage(String result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }
}
