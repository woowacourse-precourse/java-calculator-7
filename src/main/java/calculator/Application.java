package calculator;

import calculator.IO.Input;
import calculator.IO.Output;
import calculator.config.AppConfig;
import calculator.domain.Calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        String input = Input.readLine();

        Calculator calculator = appConfig.calculator(input);
        int result = calculator.calculate();

        Output.printResult(result);
    }
}
