package calculator.factory;

import calculator.calculatorApplication.Calculator;
import calculator.calculatorApplication.domain.calculation.InputValidator;
import calculator.calculatorApplication.domain.calculation.NumberExtractor;
import calculator.calculatorApplication.domain.calculation.NumberParser;
import calculator.calculatorApplication.domain.calculation.StringCalculator;
import calculator.calculatorApplication.domain.extractor.impl.DelimitedNumberExtractor;
import calculator.calculatorApplication.domain.extractor.impl.NumberExtractorChain;
import calculator.calculatorApplication.domain.extractor.impl.delimitedNumberExtractorImpl.CustomDelimiterNumberExtractor;
import calculator.calculatorApplication.domain.extractor.impl.delimitedNumberExtractorImpl.StandardDelimiterNumberExtractor;
import calculator.calculatorApplication.domain.parser.impl.StringCalculatorNumberParser;
import calculator.calculatorApplication.domain.validator.impl.StringCalculatorValidator;
import calculator.calculatorApplication.domain.validator.impl.ValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.BasicFormatValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.CompositeValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.CustomTokenFormatValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.EmptyInputValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.NullInputValidationRule;
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