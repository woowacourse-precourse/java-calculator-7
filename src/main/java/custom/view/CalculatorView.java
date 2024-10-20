package custom.view;

public class CalculatorView {
    public void displayInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}