package calculator;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //String inputString = "//-\n1,2:3-9";

        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();

        String inputString = calculatorIO.input();
        System.out.println(inputString);
        Map<String, String> splitString = calculator.split(inputString);

//        calculator.getDivision(splitString.get("division"));
//        calculator.getNumbers(splitString.get("number"));
        int result = calculator.calculateNumber();

        calculatorIO.output(result);
    }
}
