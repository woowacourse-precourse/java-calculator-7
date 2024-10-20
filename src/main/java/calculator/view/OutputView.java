package calculator.view;

public class OutputView {

    public void printBeforeReadUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printSumResult(Object result) {
        System.out.println("결과 : " + result);
    }
}
