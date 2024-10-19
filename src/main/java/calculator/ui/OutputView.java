package calculator.ui;

public class OutputView implements OutputHandler {

    private static final String OUTPUT_MESSAGE = "결과 : ";

    public OutputView() {
    }

    @Override
    public void output(int result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
