package calculator.model;

public class Output {

    public void promptForInput() {
        printMessage("덧셈할 문자열을 입력해 주세요.");
    }

    public void displayResult(int result) {
        printMessage("결과 : " + result);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
