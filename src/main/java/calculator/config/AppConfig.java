package calculator.config;

import calculator.calculator.StringCalculator;
import calculator.calculator.operator.impl.Addition;
import calculator.extractor.DelimiterExtractor;
import calculator.extractor.NumberExtractor;
import calculator.parsing.StringNumberParser;
import calculator.parsing.UserInputParser;

public class AppConfig {
    public StringCalculator stringCalculator() {
        return new StringCalculator(new StringNumberParser(), userInputParser(), new Addition());
    }

    private UserInputParser userInputParser() {
        return new UserInputParser(new DelimiterExtractor(), new NumberExtractor());
    }
}
