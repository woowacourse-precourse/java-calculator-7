package calculator;


import calculator.analyzer.DelimiterAnalyzer;
import calculator.extractor.NumberExtractor;
import calculator.myCalculator.AddCalculator;
import calculator.util.DelimiterRegexGenerator;
import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        DelimiterAnalyzer delimiterAnalyzer = new DelimiterAnalyzer();
        DelimiterRegexGenerator delimiterRegexGenerator = new DelimiterRegexGenerator();
        NumberExtractor numberExtractor = new NumberExtractor(delimiterRegexGenerator, delimiterAnalyzer);

        // 사용자 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력 검사
        InputValidator inputValidator = new InputValidator(delimiterRegexGenerator, delimiterAnalyzer);
        inputValidator.isValid(input);

        // 문자열 덧셈 계산기로 계산
        AddCalculator calculator = new AddCalculator();
        System.out.println("결과 : " + calculator.addNumbers(numberExtractor.extractNumber(input)));
    }
}