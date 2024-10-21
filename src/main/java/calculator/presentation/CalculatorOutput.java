package calculator.presentation;

import java.text.MessageFormat;

public class CalculatorOutput {

    public void print(CalculatorResponse response) {
        System.out.print(MessageFormat.format("결과 : {0}", response.getResult()));
    }
}
