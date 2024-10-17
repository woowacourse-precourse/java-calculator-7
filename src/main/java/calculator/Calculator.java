package calculator;

public class Calculator {
    private final String inputString;
    private int sum = 0;

    private Calculator() {
        this.inputString = Input.input();
    }

    private void printResult() {
        System.out.println("결과 : " + this.sum);
    }
}
