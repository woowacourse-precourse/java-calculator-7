package calculator.presentation;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderRequest;
import calculator.adder.NumberAdderResponse;
import calculator.tokenizer.TokenResponse;
import calculator.tokenizer.Tokenizer;

public class CalculatorController {

    private final NumberAdder numberAdder;
    private final Tokenizer tokenizer;
    private final CalculatorInput input;
    private final CalculatorOutput output;

    public CalculatorController(
            NumberAdder numberAdder,
            Tokenizer tokenizer,
            CalculatorInput input,
            CalculatorOutput output
    ) {
        this.numberAdder = numberAdder;
        this.tokenizer = tokenizer;
        this.input = input;
        this.output = output;
    }

    public void run() {
        // read
        CalculatorRequest calculatorRequest = input.read();

        // set custom delimiter
        if (calculatorRequest.getCustomDelimiter() != null) {
            tokenizer.setCustomDelimiter(calculatorRequest.getCustomDelimiter());
        }
        // tokenizer
        TokenResponse tokenResponse = tokenizer.parse(calculatorRequest.getTokens());

        // add token number
        NumberAdderRequest numberAdderRequest = NumberAdderRequest.of(tokenResponse.getSeperatedValues());
        NumberAdderResponse numberAdderResponse = numberAdder.addNumberToken(numberAdderRequest);

        // print
        CalculatorResponse calculatorResponse = CalculatorResponse.of(numberAdderResponse.getValue());
        output.print(calculatorResponse);
    }
}
