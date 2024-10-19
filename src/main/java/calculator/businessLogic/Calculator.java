package calculator.businessLogic;

import calculator.domain.CalculatorParam;

import static calculator.message.Message.결과안내문;

public class Calculator {

    private final Input input;

    protected Calculator() {
        this.input = Input.of();
    }

    public static Calculator of() {
        return new Calculator();
    }

    public void calculate() {
        String userInput = input.getInput();
        tryCalculate(userInput);
    }

    private void tryCalculate(String userInput) {
        try{
            CalculatorParam domain = input.getUserNumber(userInput);
            System.out.println(결과안내문 + domain.getSumNumbers());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
