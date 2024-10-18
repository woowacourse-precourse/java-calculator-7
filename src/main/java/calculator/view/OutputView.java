package calculator.view;

public class OutputView {
    public static void displayStart() {
        OutputWriter.displayMessage("덧셈할 문자열을 입력해 주세요.");
    } // displayStart

    public static void displayResult(int result) {
        OutputWriter.displayMessage("결과 : " + result);
    } // displayResult
} // class