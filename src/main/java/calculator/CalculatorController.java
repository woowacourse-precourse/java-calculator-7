package calculator;

import calculator.adder.NumberAdder;
import calculator.adder.NumberAdderRequest;
import calculator.adder.NumberAdderResponse;
import calculator.tokenizer.TokenResponse;
import calculator.tokenizer.Tokenizer;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    private final NumberAdder numberAdder;
    private final Tokenizer tokenizer;

    public CalculatorController(NumberAdder numberAdder, Tokenizer tokenizer) {
        this.numberAdder = numberAdder;
        this.tokenizer = tokenizer;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();

        tokenizer.setCustomDelimiter(input);

        TokenResponse tokenResponse = tokenizer.parse(input);

        NumberAdderRequest numberAdderRequest = NumberAdderRequest.of(tokenResponse.getSeperatedValues());
        NumberAdderResponse numberAdderResponse = numberAdder.addNumberToken(numberAdderRequest);

        System.out.println(numberAdderResponse.getValue());
    }
}
