package calculator;

import calculator.utils.CalculatorUtils;

public class Application {
    public static void main(String[] args) {

        Application application = new Application();

        application.startCalculator();
        // TODO: 프로그램 구현


    }

    private void startCalculator() {

        CalculatorUtils calculatorUtils = new CalculatorUtils();

        String inputNumber = calculatorUtils.requestNumber();

        DelimiterSeparator separator = new DelimiterSeparator();

        String[] separatedNumber = separator.separateNumber(inputNumber);

        int sum = calculatorUtils.addNumber(separatedNumber);
        
        calculatorUtils.printResult(sum);


    }
}
