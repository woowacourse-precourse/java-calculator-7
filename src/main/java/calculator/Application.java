package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculation stringCalculation =
                new StringCalculation(new InputView(), new ResultView());

        stringCalculation.startCalculate();
    }
}
