package calculator.view;

public class OutputView {

    public void printInputRequest() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printCalculatedResult(int result) {
        System.out.println("결과 : " + result);
    }
}
