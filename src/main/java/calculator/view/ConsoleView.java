package calculator.view;

public class ConsoleView {
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printError(String message) {
        System.out.println("에러 : " + message);
    }
}