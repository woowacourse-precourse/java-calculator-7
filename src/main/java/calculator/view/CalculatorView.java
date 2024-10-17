package calculator.view;

public class CalculatorView implements View {
    @Override
    public void print(int sumResult) {
        System.out.println("결과 : " + sumResult);
    }
}
