package calculator.calculator;

import calculator.extractor.CompositeTokenExtractor;
import calculator.extractor.CustomTokenExtractor;
import calculator.extractor.DefaultTokenExtractor;
import calculator.extractor.TokenExtractor;
import calculator.parser.NumberParser;
import calculator.parser.StringCalculatorNumberParser;
import calculator.validationRule.BasicFormatValidationRule;
import calculator.validationRule.CompositeValidationRule;
import calculator.validationRule.CustomTokenFormatValidationRule;
import calculator.validationRule.EmptyInputValidationRule;
import calculator.validationRule.NullInputValidationRule;
import calculator.validator.InputValidator;
import calculator.validator.StringCalculatorValidator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorImplTest {

    @DisplayName("그냥 동작 테스트")

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void test(String input) {
        InputValidator inputValidator = new StringCalculatorValidator(
                new CompositeValidationRule(List.of(
                        new EmptyInputValidationRule(),
                        new NullInputValidationRule(),
                        new BasicFormatValidationRule(),
                        new CustomTokenFormatValidationRule()
                ))
        );
        TokenExtractor tokenExtractor = new CompositeTokenExtractor(List.of(
                new DefaultTokenExtractor(),
                new CustomTokenExtractor()
        ));
        NumberParser numberParser = new StringCalculatorNumberParser();

        StringCalculatorImpl stringCalculator = new StringCalculatorImpl(inputValidator, tokenExtractor, numberParser);
        int calculate = stringCalculator.calculate(input);
        System.out.println(calculate);
        Assertions.assertEquals(calculate, 6);
    }
}