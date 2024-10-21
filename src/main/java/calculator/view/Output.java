package calculator.view;

public class Output {
    private final static String CALC_RESULT_MESSAGE = "결과 : ";

    public void printCalcResult(int sum) {
        System.out.println(CALC_RESULT_MESSAGE + sum);
    }
}
