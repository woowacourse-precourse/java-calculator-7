package calculator.parser;

import calculator.validator.Validator;

import java.util.List;

public class InputParser {

    private final DelimiterParser delimiterParser;
    private final NumberConverter numberConverter;
    private final Validator validator;

    public InputParser(DelimiterParser delimiterParser, NumberConverter numberConverter, Validator validator) {
        this.delimiterParser = delimiterParser;
        this.numberConverter = numberConverter;
        this.validator = validator;
    }

    public List<Integer> parse(String input) {
        //구분자 파싱
        String[] strNumbers = delimiterParser.parseDelimiters(input);

        // 유효성 검사
        for (String numberString : strNumbers) {
            validator.numberValidate(numberString);
        }

        //숫자를 변환
        return numberConverter.convertToNumbers(strNumbers);
    }//parse
}//class
