package calculator.handler;

public class OutputHandler {
    public void printInitMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
