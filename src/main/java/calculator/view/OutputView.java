package calculator.view;

public class OutputView {
    private static final String OUTPUT_MESSAGE_RESULT = "결과 : %d\n";

    public void outputMessage(int result) {
        System.out.printf(OUTPUT_MESSAGE_RESULT, result);
    }

    public void outputErrorMessage(String input) {
        System.out.println(input);
    }
}
