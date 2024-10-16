package calculator.io.output;

public class OutputHandler {

    public void showUserInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void showAdditionResult(int calculateResult) {
        System.out.println("결과 : " + calculateResult);
    }

}
