package calculator.view;

public class OutputView {
    private static final String CALCULATE_RESULT_MESSAGE = "결과 : ";

    public static void printCalculateResultMessage(int calculateResult){
        System.out.println(CALCULATE_RESULT_MESSAGE+calculateResult);
    }

}
