package calculator;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderImpl;
import calculator.presentation.CalculatorInput;
import calculator.presentation.parser.InputParser;
import calculator.presentation.parser.RegexInputParser;
import calculator.tokenizer.Delimiters;
import calculator.tokenizer.RegexTokenizer;
import calculator.tokenizer.Tokenizer;

public class Application {

    public static void main(String[] args) {
        InputParser inputParser = new RegexInputParser();
        CalculatorInput calculatorInput = new CalculatorInput(inputParser);
        NumberAdder numberAdder = new NumberAdderImpl();
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        CalculatorController calculatorController = new CalculatorController(numberAdder, tokenizer, calculatorInput);
        calculatorController.run();
    }
}
