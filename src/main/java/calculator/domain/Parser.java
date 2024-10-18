package calculator.domain;

import calculator.domain.model.PreprocessedInput;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<Integer> parsedNumbers;
    private final PreprocessedInput preprocessedInput;

    public Parser(PreprocessedInput preprocessedInput) {
        this.preprocessedInput = preprocessedInput;
        this.parsedNumbers = new ArrayList<>();
    }

    public List<Integer> parse() {
        String regax = buildDelimiterRegex(preprocessedInput.delimiters());
        String[] splitNumbers = preprocessedInput.unparsedNumber().split(regax);
        for (String splitNumber : splitNumbers) {
            try {
                parsedNumbers.add(Integer.parseInt(splitNumber));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        return parsedNumbers;
    }

    /**
     * 정규표현식에서 특수문자를 사용하려면 "\\"를 붙여야 함
     * 예) "," -> "\\,"
     * | 을 쓰면 OR 조건이라는 의미
     * ex) List.of(",", ";") -> "\\,|\\;"
     */
    private String buildDelimiterRegex(List<Character> delimiters) {
        StringBuilder regex = new StringBuilder();
        for (Character delimiter : delimiters) {
            regex.append("\\").append(delimiter).append("|");
        }
        // 마지막 "|" 제거
        return regex.substring(0, regex.length() - 1);
    }

}
