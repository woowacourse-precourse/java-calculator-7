package calculator;

import calculator.input.InputReader;
import calculator.output.OutputWriter;
import calculator.stringcalculator.StringCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();

        StringCalculator stringCalculator = appConfig.stringCalculator();
        String input = inputReader.readLine();
        String result = stringCalculator.operate(input);
        outputWriter.writer(result);

        inputReader.close();
    }
}
