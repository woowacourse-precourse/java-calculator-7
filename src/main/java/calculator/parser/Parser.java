package calculator.parser;

import java.util.List;

public class Parser {
    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public Parser(){
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser();
    }

    /**
     * 입려된 문자열에서 커스텀 구분자를 추가하고 구분자를 기준으로 숫자를 잘라주는 메서드
     * @param input 입력된 문자열
     * @return 구분자로 기주은로 잘라진 숫자
     */
    public List<Integer> parser(String input){
        String delimiters = delimiterParser.parseDelimiter(input);
        String numbers = delimiterParser.extractNumbers(input);
        return numberParser.parseNumbers(numbers, delimiters);
    }
}
