package calculator.view.output;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    @Override
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
