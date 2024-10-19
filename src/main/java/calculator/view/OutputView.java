package calculator.view;

/**
 * 결과 출력을 위한 OutputView
 */
public class OutputView {
    private static final String CALCULATE_RESULT_MESSAGE = "결과 : ";

    /**
     * 결과를 출력하기 위한 메소드
     * @param result
     */
    public void printResult(Integer result) {
        System.out.println(CALCULATE_RESULT_MESSAGE + result);
    }
}
