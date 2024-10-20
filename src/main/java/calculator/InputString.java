package calculator;

import calculator.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    private final String inputString;
    private final String NUMBER_REGEX = "^\\d.*";
    private final String PATTERN_REGEX = "^//([^0-9])\\\\n(.*)";

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public boolean isBlank() {
        return inputString.isBlank();
    }

    public boolean containsCustomSeperator() {
        return inputString.startsWith("//");
    }

    public boolean notContainsCustomSeperator() {
        Pattern compile = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = compile.matcher(inputString);
        return matcher.matches();  // 숫자로 시작하는지
    }

    public List<String> extractCustomSeperator() {
        List<String> list = new ArrayList<>();

        Pattern compile = Pattern.compile(PATTERN_REGEX);
        Matcher matcher = compile.matcher(inputString);

        Validator.validateCustomSeperator(inputString);

        if (matcher.matches()) {
            list.add(matcher.group(1));  // 커스텀 구분자 추출
            list.add(matcher.group(2));  // 나머지 숫자 부분
        } else {
            throw new IllegalArgumentException("커스텀 구분자를 올바르게 지정하지 않았습니다.");
        }

        return list;
    }

    public String getInputString() {
        return inputString;
    }
}
