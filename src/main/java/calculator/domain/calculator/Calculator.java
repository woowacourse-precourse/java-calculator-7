package calculator.domain.calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {

    private final List<String> delimeters = new ArrayList<>(Arrays.asList(",", ":"));
    private final Validator validator;
    private final String[] splitInput;

    public Calculator(String input) {
        this.validator = new Validator();
        this.splitInput = setSplitInput(input);
    }

    /**
     * 1. 입력 문자열에서 커스텀 구분자가 있는 경우, 이를 추출하여 구분자 목록에 저장한다.
     * 2. 커스텀 구분자를 사용하는 경우, 선언부 뒤의 숫자 부분을 input으로 설정한다.
     */
    private String setDelimitersAndFilteringInputText(String input) {
        // 커스텀 구분자가 한 글자인지 검증한 뒤 추출
        String delimiter = validator.extractCustomDelimiter(input);
        if(!delimiter.isEmpty()) {
            delimeters.add(delimiter);
        }
        return validator.extractNumbersPart(input);
    }

    /**
     * 입력된 문자열을 정의된 구분자들(커스텀 구분자 포함)을 통해 분리하는 기능.
     */
    public String[] setSplitInput(String input) {
        input = setDelimitersAndFilteringInputText(input);
        // 구분자를 정규 표현식으로 변환 (특수문자 이스케이프 처리)
        String delimiterRegex = delimeters.stream()
                .map(Pattern::quote)
                .reduce((delim1, delim2) -> delim1 + "|" + delim2)
                .orElse("");

        // 문자열 분리
        return input.split(delimiterRegex);
    }

    /**
     * 숫자 추출 및 검증 후 합계 계산
     */
    public int sum() {
        int sum = 0;
        for (String number : splitInput) {
            if (number == null || number.isEmpty()) {
                continue;
            }
            validator.validatePositiveNumber(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
