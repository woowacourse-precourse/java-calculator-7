package calculator;

public class OutputView {

    public void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResultMessage(int result) {
        System.out.println("결과 : " + result);
    }
}
