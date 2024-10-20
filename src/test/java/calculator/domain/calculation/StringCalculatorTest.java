package calculator.domain.calculation;

import calculator.domain.extractor.impl.NumberExtractorChain;
import calculator.domain.extractor.impl.delimitedNumberExtractorImpl.CustomDelimiterNumberExtractor;
import calculator.domain.extractor.impl.delimitedNumberExtractorImpl.StandardDelimiterNumberExtractor;
import calculator.domain.parser.impl.StringCalculatorNumberParser;
import calculator.domain.validator.impl.StringCalculatorValidator;
import calculator.domain.validator.impl.validationRule.BasicFormatValidationRule;
import calculator.domain.validator.impl.validationRule.CompositeValidationRule;
import calculator.domain.validator.impl.validationRule.CustomTokenFormatValidationRule;
import calculator.domain.validator.impl.validationRule.EmptyInputValidationRule;
import calculator.domain.validator.impl.validationRule.NullInputValidationRule;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("그냥 동작 테스트")

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\\n1;2;3"})
    void test(String input) {
        InputValidator inputValidator = new StringCalculatorValidator(
                new CompositeValidationRule(List.of(
                        new EmptyInputValidationRule(),
                        new NullInputValidationRule(),
                        new BasicFormatValidationRule(),
                        new CustomTokenFormatValidationRule()
                ))
        );

        NumberExtractorChain numberExtractorChain = new NumberExtractorChain(
                List.of(new StandardDelimiterNumberExtractor(),
                        new CustomDelimiterNumberExtractor()));
        NumberParser numberParser = new StringCalculatorNumberParser();

        StringCalculator stringCalculator = new StringCalculator(inputValidator, numberExtractorChain,
                numberParser);
        int calculate = stringCalculator.calculate(input);
        Assertions.assertEquals(calculate, 6);
    }
}