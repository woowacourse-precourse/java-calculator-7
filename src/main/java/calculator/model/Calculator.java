package calculator.model;

import calculator.model.token.CustomDelimiterToken;
import calculator.model.token.NumbersToken;
import calculator.model.token.Tokenizer;

public class Calculator {

    private boolean defaultMode;
    private Tokenizer tokenizer;

    public Calculator() {
        this.tokenizer = new Tokenizer();
    }

    public void calculate(String input) {
        setMode(input);

        Delimiter delimiter = selectDelimiter(input);

        NumbersToken numbersToken = tokenizer.createNumbersToken(input);

        System.out.println(delimiter);
        System.out.println(numbersToken);
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
