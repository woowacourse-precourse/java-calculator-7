package calculator.view;

public class OutputView {
    public static void startingMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void showResultMessage(int result) {
        System.out.println("결과 : " + result);
    }
}
