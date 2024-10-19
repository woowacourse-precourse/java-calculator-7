package calculator.view;

public class OutputView {

    public void requestAdditionNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(int result) {
        System.out.printf("결과 : %d", result);
    }
}
