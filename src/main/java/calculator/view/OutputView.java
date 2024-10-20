package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printSumToUser(String sumOfNumbers){
        System.out.println(RESULT_MESSAGE + sumOfNumbers);
    }
}
