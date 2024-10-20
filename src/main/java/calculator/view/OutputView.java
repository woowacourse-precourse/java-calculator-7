package calculator.view;

public class OutputView {
    public void displayResult(int result) {
        System.out.println("결과: " + result);
    }

    public void displayErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}
