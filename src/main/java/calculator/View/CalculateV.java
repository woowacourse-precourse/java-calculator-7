package calculator.View;

public class CalculateV {

    public void promptInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.out.println(message);
    }

}