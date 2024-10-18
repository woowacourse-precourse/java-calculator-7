package calculator;

public class OutputHandler {
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printError(String errorMessage) {
        System.out.println("에러: " + errorMessage);
    }
}
