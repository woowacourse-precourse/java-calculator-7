package calculator;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderImpl;
import calculator.presentation.CalculatorController;
import calculator.presentation.input.CalculatorInput;
import calculator.presentation.output.CalculatorOutput;
import calculator.presentation.parser.InputParser;
import calculator.presentation.parser.RegexInputParser;
import calculator.tokenizer.Delimiters;
import calculator.tokenizer.RegexTokenizer;
import calculator.tokenizer.Tokenizer;

public class Application {

    public static void main(String[] args) {
        InputParser inputParser = new RegexInputParser();
        CalculatorInput calculatorInput = new CalculatorInput(inputParser);
        CalculatorOutput calculatorOutput = new CalculatorOutput();
        NumberAdder numberAdder = new NumberAdderImpl();
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        CalculatorController calculatorController = new CalculatorController(numberAdder, tokenizer, calculatorInput, calculatorOutput);
        calculatorController.run();
    }
}
