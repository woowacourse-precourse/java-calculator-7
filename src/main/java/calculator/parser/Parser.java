package calculator.parser;

import calculator.domain.delimiter_input.DelimiterInput;
import java.util.regex.Pattern;

/**
 * Parser 클래스는 DelimiterInput을 사용하여 입력 문자열을 구분자를 기준으로 분리하는 역할을 합니다.
 */
public class Parser {

    /**
     * 입력된 DelimiterInput 객체에서 구분자 패턴과 입력 문자열을 가져와,
     * 구분자에 따라 문자열을 분리한 후 TokenList 객체로 반환합니다.
     *
     * @param delimiterInput 구분자 패턴과 입력 문자열을 포함하는 DelimiterInput 객체
     * @return 분리된 문자열을 포함하는 TokenList 객체
     */
    public TokenList parse(DelimiterInput delimiterInput) {
        String delimiterPattern = delimiterInput.getDelimiterPattern();  // 구분자 패턴
        String input = delimiterInput.getInput();  // 입력 문자열

        // 구분자 패턴에 따라 입력 문자열을 분리하여 토큰 배열을 생성
        String[] tokens = Pattern.compile(delimiterPattern).split(input);
        return new TokenList(tokens);  // 분리된 토큰 배열을 TokenList로 감싸서 반환
    }
}
