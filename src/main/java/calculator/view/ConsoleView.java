package calculator.view;

public class ConsoleView {
    public void displayInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void displayResult(Integer result) {
        System.out.println("결과 : " + result);
    }
}
