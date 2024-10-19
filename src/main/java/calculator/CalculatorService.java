package calculator;

public class CalculatorService {
    private final String input;

    public CalculatorService(String input) {
        this.input = input;
    }

    public void calculate() {

        try(Calculator calculator = new Calculator(input)) {
            calculator.process();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다." + e.getMessage());
        }
    }

}
