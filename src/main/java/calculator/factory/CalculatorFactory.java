package calculator.factory;

import calculator.calculatorApplication.Calculator;
import calculator.domain.calculation.InputValidator;
import calculator.domain.calculation.NumberExtractor;
import calculator.domain.calculation.NumberParser;
import calculator.domain.calculation.StringCalculator;
import calculator.domain.extractor.impl.DelimitedNumberExtractor;
import calculator.domain.extractor.impl.NumberExtractorChain;
import calculator.domain.extractor.impl.delimitedNumberExtractorImpl.CustomDelimiterNumberExtractor;
import calculator.domain.extractor.impl.delimitedNumberExtractorImpl.StandardDelimiterNumberExtractor;
import calculator.domain.parser.impl.StringCalculatorNumberParser;
import calculator.domain.validator.impl.StringCalculatorValidator;
import calculator.domain.validator.impl.ValidationRule;
import calculator.domain.validator.impl.validationRule.BasicFormatValidationRule;
import calculator.domain.validator.impl.validationRule.CompositeValidationRule;
import calculator.domain.validator.impl.validationRule.CustomTokenFormatValidationRule;
import calculator.domain.validator.impl.validationRule.EmptyInputValidationRule;
import calculator.domain.validator.impl.validationRule.NullInputValidationRule;
import java.util.List;

public class CalculatorFactory {
    public static Calculator createCalculator() {
        InputValidator inputValidator = createInputValidator();
        NumberExtractor numberExtractor = createNumberExtractor();
        NumberParser numberParser = createNumberParser();

        return new StringCalculator(inputValidator, numberExtractor, numberParser);
    }

    private static InputValidator createInputValidator() {
        List<ValidationRule> rules = List.of(
                new EmptyInputValidationRule(),
                new NullInputValidationRule(),
                new BasicFormatValidationRule(),
                new CustomTokenFormatValidationRule()
        );
        CompositeValidationRule compositeValidationRule = new CompositeValidationRule(rules);
        return new StringCalculatorValidator(compositeValidationRule);
    }

    private static NumberExtractor createNumberExtractor() {
        List<DelimitedNumberExtractor> delimitedNumberExtractors = List.of(
                new StandardDelimiterNumberExtractor(),
                new CustomDelimiterNumberExtractor()
        );
        return new NumberExtractorChain(delimitedNumberExtractors);
    }

    private static NumberParser createNumberParser() {
        return new StringCalculatorNumberParser();
    }
}