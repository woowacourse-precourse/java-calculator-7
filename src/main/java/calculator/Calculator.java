package calculator;

import java.util.Objects;

public class Calculator {

    private final InputParam inputParam;

    protected Calculator() {
        this.inputParam = InputParam.of();
    }

    public static Calculator of() {
        return new Calculator();
    }

    public void calculate() {
        while(true) {
            String userInput = inputParam.getInput();
            if(Objects.equals(userInput, "exit\n")){
                break;
            }
            CalculatorParamDomain domain = inputParam.getUserNumber(userInput);
            System.out.println(domain.getSumNumbers());
        }
    }
}
