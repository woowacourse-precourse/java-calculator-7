package calculator;

import calculator.calculator.StringCalculatorImpl;
import calculator.extractor.developed.CustomDelimiterNumberExtractorTest;
import calculator.extractor.developed.NumberExtractorChainTest;
import calculator.extractor.developed.StandardDelimiterNumberExtractorTest;
import calculator.inputReader.ConsoleInputReader;
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

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
        NumberExtractorChainTest numberExtractorChain = new NumberExtractorChainTest(
                List.of(new StandardDelimiterNumberExtractorTest(), new CustomDelimiterNumberExtractorTest()));
        NumberParser numberParser = new StringCalculatorNumberParser();

//        StringCalculatorImpl calculator = new StringCalculatorImpl(inputValidator, delimitedNumberExtractor,
//                numberParser);
        StringCalculatorImpl calculator = new StringCalculatorImpl(inputValidator, numberExtractorChain,
                numberParser);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
//        System.out.println("1");
        String readLine = consoleInputReader.readLine();
//        System.out.println("2");
        int result = calculator.calculate(readLine);
        System.out.println("결과 : " + result);
    }
}
