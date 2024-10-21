package calculator.view;

public class OutputView {
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
    public static void printError(String errorMessage) {
        System.out.println("오류 : " + errorMessage);
    }
}
