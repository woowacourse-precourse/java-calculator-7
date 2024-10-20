package calculator;

import calculator.domain.StringCalculator;
import calculator.io.InputReader;
import calculator.io.OutputWriter;


public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        StringCalculator stringCalculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = inputReader.readInput();
//        try {
//            int total = stringCalculator.calculate(input);
//            outputWriter.writeOutput(total);
//        } catch (IllegalArgumentException e) {
//            outputWriter.writeOutput(e.getMessage());
        int total = stringCalculator.calculate(input);
        outputWriter.writeOutput(total);
    }
}

