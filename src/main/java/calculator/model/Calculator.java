package calculator.model;

import calculator.model.token.CustomDelimiterToken;
import calculator.model.token.NumbersToken;
import calculator.model.token.Tokenizer;
import java.util.Arrays;

public class Calculator {

    private boolean defaultMode;
    private Tokenizer tokenizer;

    public Calculator() {
        this.tokenizer = new Tokenizer();
    }

    public int calculate(String input) {
        setMode(input);

        Delimiter delimiter = selectDelimiter(input);

        String[] split = input.split(",", -1);
        System.out.println(Arrays.toString(split));

        NumbersToken numbersToken = tokenizer.createNumbersToken(input);

        if (numbersToken.isEmpty()) {
            return 0;
        }

        Numbers numbers = numbersToken.convertToNumbers(delimiter);

        return sum(numbers);
    }

    public int sum(Numbers numbers) {
        return numbers.sum();
    }

    public Delimiter selectDelimiter(String input) {
        if (defaultMode) {
            return new Delimiter(",|:");
        }

        CustomDelimiterToken customDelimiterToken = tokenizer.createCustomDelimiterToken(input);
        return new Delimiter(customDelimiterToken.extractDelimiter());
    }

    public void setMode(String input) {
        if (tokenizer.isExistsCustomDelimiterToken(input)) {
            defaultMode = false;
        } else {
            defaultMode = true;
        }
    }
}
