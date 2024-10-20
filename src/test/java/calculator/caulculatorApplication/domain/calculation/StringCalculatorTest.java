package calculator.caulculatorApplication.domain.calculation;

import calculator.calculatorApplication.domain.calculation.InputValidator;
import calculator.calculatorApplication.domain.calculation.NumberParser;
import calculator.calculatorApplication.domain.calculation.StringCalculator;
import calculator.calculatorApplication.domain.extractor.impl.NumberExtractorChain;
import calculator.calculatorApplication.domain.extractor.impl.delimitedNumberExtractorImpl.CustomDelimiterNumberExtractor;
import calculator.calculatorApplication.domain.extractor.impl.delimitedNumberExtractorImpl.StandardDelimiterNumberExtractor;
import calculator.calculatorApplication.domain.parser.impl.StringCalculatorNumberParser;
import calculator.calculatorApplication.domain.validator.impl.StringCalculatorValidator;
import calculator.calculatorApplication.domain.validator.impl.validationRule.BasicFormatValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.CompositeValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.CustomTokenFormatValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.EmptyInputValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.NullInputValidationRule;
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