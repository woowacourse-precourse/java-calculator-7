package calculator;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderImpl;
import calculator.presentation.CalculatorController;
import calculator.presentation.CalculatorInput;
import calculator.presentation.CalculatorOutput;
import calculator.presentation.InputParser;
import calculator.presentation.RegexInputParser;
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
