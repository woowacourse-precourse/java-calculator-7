package calculator.view;

public class ResultView {
    public static void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void displayError(String message) {
        System.out.println(message);
    }
}