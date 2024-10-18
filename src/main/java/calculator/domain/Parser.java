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
        String regex = buildDelimiterRegex(preprocessedInput.delimiters());
        String[] splitNumbers = preprocessedInput.unparsedNumber().split(regex);
        for (String splitNumber : splitNumbers) {
            try {
                Integer parsedNumber = convertToPositiveIntegerOrThrow(splitNumber);
                parsedNumbers.add(parsedNumber);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        return parsedNumbers;
    }

    private Integer convertToPositiveIntegerOrThrow(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if(parsedNumber < 0) {
                throw new IllegalArgumentException();
            }
            return parsedNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
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
