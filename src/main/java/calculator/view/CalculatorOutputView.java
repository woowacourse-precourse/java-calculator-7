package calculator.view;

public class CalculatorOutputView {

    public void init() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(int result) {
        System.out.print("결과 : " + result);
    }
}
