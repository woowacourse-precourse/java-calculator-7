package calculator.view;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "결과 : ";

    /**
     * 계산 결과를 출력하는 메서드.
     *
     * @param result 출력할 결과 값
     */
    public void output(int result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }
}
