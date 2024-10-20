package calculator.validator;

import calculator.analyzer.DelimiterAnalyzer;
import calculator.util.DelimiterRegexGenerator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private final DelimiterRegexGenerator delimiterRegexGenerator;
    private final DelimiterAnalyzer delimiterAnalyzer;

    public InputValidator(DelimiterRegexGenerator delimiterRegexGenerator, DelimiterAnalyzer delimiterAnalyzer) {
        this.delimiterRegexGenerator = delimiterRegexGenerator;
        this.delimiterAnalyzer = delimiterAnalyzer;
    }

    // 사용자 입력이 잘못된 입력인지 검사 (잘못된 입력의 경우 예외를 던짐)
    public void isValid(String input) {

        // 구분자 리스트를 받아서 구분자 정규식 생성
        String regex = delimiterRegexGenerator.generateDelimiterRegex(delimiterAnalyzer.getDelimiterList(input));

        // 사용자 입력 정제 (실제 숫자와 구분자가 나타나는 부분만 추출)
        String trimmedInput = input;
        if(delimiterAnalyzer.isContainCustomDelimiter(input))
            trimmedInput = input.substring(5, input.length());

        // 구분자 정규식을 통해 입력 split -> 숫자(String type)만 담은 리스트
        List<String> strNumList = Arrays.stream(trimmedInput.split(regex)).toList();

        // 빈 문자열 제거 (입력이 "1,,,2,3 같은 경우 split한 결과에 빈 문자열이 포함되어 있음)
        strNumList = strNumList.stream().filter(i -> !i.equals("")).toList();

        // 숫자가 아닌 문자 포함하는 요소가 있는 경우 잘못된 입력
        // 구분자 이외의 문자가 포함되는 경우이기 때문에 오류 (음수를 입력하는 경우도 포함됨)
        for(String strNum : strNumList) {
            for(char c : strNum.toCharArray()) {;
                if(!Character.isDigit(c)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

}