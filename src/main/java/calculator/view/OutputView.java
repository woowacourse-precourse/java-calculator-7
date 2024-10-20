package calculator.view;

public class OutputView {

    public static void printError(String error) {
        System.out.println(error);
    }

    public static void printResult(int result) {
        System.out.print("결과 : " + result);
    }
}
