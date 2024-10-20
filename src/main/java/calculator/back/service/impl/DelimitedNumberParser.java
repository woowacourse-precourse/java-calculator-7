package calculator.back.service.impl;

import calculator.back.exception.InvalidInputException;
import calculator.back.exception.message.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimitedNumberParser {

    static List<Integer> parseDelimitedNumber(String inputWithDelimiters, List<Character> delimiters) {
        // 구분자들을 Regex 형식으로 추출 ex) [;:]
        String delimiterRegex = DelimiterRegexBuilder.buildDelimiterRegex(delimiters);

        // 입력받고자 하는 포맷에 적합한지 Regex를 통해 검증 ^[1-9]\d*(?:[Delimiter][1-9]\d*)*$
        String patternString = "^[1-9]\\d*(?:" + delimiterRegex + "[1-9]\\d*)*$";
        Matcher matcher = Pattern.compile(patternString).matcher(inputWithDelimiters);

        if (matcher.matches() == false) {
            throw new InvalidInputException(ExceptionMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
        // 구분자를 기준으로 문자열 분리 및 숫자 추출
        String[] numberStrings = inputWithDelimiters.split(delimiterRegex);
        return Arrays.stream(numberStrings).map(Integer::parseInt).toList();
    }
}
