package calculator;

public class Calculator {

    private final InputParam inputParam;

    protected Calculator() {
        this.inputParam = InputParam.of();
    }

    public static Calculator of() {
        return new Calculator();
    }

    public void calculate() {
        String userInput = inputParam.getInput();
        tryCalculate(userInput);
    }

    private void tryCalculate(String userInput) {
        try{
            CalculatorParamDomain domain = inputParam.getUserNumber(userInput);
            System.out.println("결과 : " + domain.getSumNumbers());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
