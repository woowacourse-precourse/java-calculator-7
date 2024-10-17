package calculator.view;

public class OutputView {
    private static final String END_MESSAGE = "결과 : ";

    public static void printResult(int resultValue){
        System.out.println(END_MESSAGE + resultValue);
    }
}
