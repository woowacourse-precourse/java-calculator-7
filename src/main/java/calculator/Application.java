package calculator;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderImpl;
import calculator.tokenizer.Delimiters;
import calculator.tokenizer.RegexTokenizer;
import calculator.tokenizer.Tokenizer;

public class Application {

    public static void main(String[] args) {
        NumberAdder numberAdder = new NumberAdderImpl();
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        CalculatorController calculatorController = new CalculatorController(numberAdder, tokenizer);
        calculatorController.run();
    }
}
