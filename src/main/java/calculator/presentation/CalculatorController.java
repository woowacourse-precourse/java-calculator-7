package calculator.presentation;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderRequest;
import calculator.adder.NumberAdderResponse;
import calculator.presentation.input.CalculatorInput;
import calculator.presentation.request.CalculatorRequest;
import calculator.tokenizer.TokenResponse;
import calculator.tokenizer.Tokenizer;

public class CalculatorController {

    private final NumberAdder numberAdder;
    private final Tokenizer tokenizer;
    private final CalculatorInput input;

    public CalculatorController(NumberAdder numberAdder, Tokenizer tokenizer, CalculatorInput input) {
        this.numberAdder = numberAdder;
        this.tokenizer = tokenizer;
        this.input = input;
    }

    public void run() {
        CalculatorRequest calculatorRequest = input.read();

        if (calculatorRequest.getCustomDelimiter() != null) {
            tokenizer.setCustomDelimiter(calculatorRequest.getCustomDelimiter());
        }
        TokenResponse tokenResponse = tokenizer.parse(calculatorRequest.getTokens());

        NumberAdderRequest numberAdderRequest = NumberAdderRequest.of(tokenResponse.getSeperatedValues());
        NumberAdderResponse numberAdderResponse = numberAdder.addNumberToken(numberAdderRequest);

        System.out.println(numberAdderResponse.getValue());
    }
}
