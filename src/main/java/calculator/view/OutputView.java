package calculator.view;

public class OutputView {

    private static final String RESULT_MESSAGE = "결과 : ";

    // 결과 출력
    public void printResult(String output) {
        System.out.println(RESULT_MESSAGE + output);
    }
}
