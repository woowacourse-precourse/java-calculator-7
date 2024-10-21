package calculator.parser;

import calculator.validate.Validator;

public class DelimiterParser {
    private static final String DELIMITERS = ",|:";
    private final String DELIMITER_PREFIX = "//";
    private final String DELIMITER_END = "\\n";

    /**
     * 입력된 문자열에서 기본 구분자에 커스텀 구분자를 추가 해주는 메서드
     * @param input 입력된 문자열
     * @return 기본 구분자와 추가된 커스텀 구분자
     */
    public String parseDelimiter(String input){
        if(input.startsWith(DELIMITER_PREFIX)){
            int index = input.indexOf(DELIMITER_END);

            Validator.checkCustomDelimiter(index);
            String customDelimiter = input.substring(2, index);
            Validator.containsNumber(customDelimiter);

            return DELIMITERS + "|" + customDelimiter;
        }
        return DELIMITERS;
    }

    /**
     * 입력된 문자열에서 숫자 부분만 잘라내주는 메서드
     * @param input 입력된 문자열
     * @return 커스텀 구분자 뒤에 있는 숫자 문자열
     */
    public String extractNumbers(String input){
        if(input.startsWith(DELIMITER_PREFIX)){
            int index = input.indexOf(DELIMITER_END);
            return input.substring(index + 2);
        }
        return input;
    }
}
