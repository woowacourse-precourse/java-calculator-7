package calculator.view;

public class OutputView {
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.out.println("잘못된 입력입니다: " + message);
    }
}
