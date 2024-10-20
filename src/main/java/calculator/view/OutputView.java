package calculator.view;

public class OutputView {

    private static final String PRINT_SUM_MESSAGE = "결과 : ";

    public void printSum(int sum) {
        System.out.println(PRINT_SUM_MESSAGE + sum);
    }
}
