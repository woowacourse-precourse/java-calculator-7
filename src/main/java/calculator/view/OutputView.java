package calculator.view;

public class OutputView {

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printResult(String message) {
        System.out.println(message);
    }
}
