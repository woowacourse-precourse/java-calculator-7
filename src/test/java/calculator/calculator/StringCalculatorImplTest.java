package calculator.calculator;

import calculator.extractor.developed.CustomDelimiterNumberExtractor;
import calculator.extractor.developed.NumberExtractorChain;
import calculator.extractor.developed.StandardDelimiterNumberExtractor;
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
//        DelimitedNumberExtractor delimitedNumberExtractor = new CompositeDelimitedNumberExtractor(List.of(
//                new DefaultDelimitedNumberExtractor(),
//                new CustomDelimitedNumberExtractor()
//        ));

        NumberExtractorChain numberExtractorChain = new NumberExtractorChain(
                List.of(new StandardDelimiterNumberExtractor(),
                        new CustomDelimiterNumberExtractor()));
        NumberParser numberParser = new StringCalculatorNumberParser();

        StringCalculatorImpl stringCalculator = new StringCalculatorImpl(inputValidator, numberExtractorChain,
                numberParser);
        int calculate = stringCalculator.calculate(input);
//        System.out.println(calculate);
        Assertions.assertEquals(calculate, 6);
    }
}