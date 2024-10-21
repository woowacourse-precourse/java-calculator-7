package calculator;

public class CalculatorOutput {
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.out.println("오류 : " + message);
    }
}
