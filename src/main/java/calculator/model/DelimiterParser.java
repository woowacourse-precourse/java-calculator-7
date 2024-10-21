package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.model.Validator.validateMatcher;

public class DelimiterParser {
    private static final String REGEX = "^(//([a-zA-Z!@#$%^&*?._=+\\-;~`|/\\\\])\\\\n)?(\\d+(?:(,|:|\\2)\\d+)*)?$|^\"\"$";
    private static final Pattern INPUT_PATTERN = Pattern.compile(REGEX);

    // 정규식으로 입력 값 검증
    public String[] inputParser(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        // 유효하지 않은 입력일 경우 예외 발생
        validateMatcher(matcher);

        // 1. 구분자 처리 (기본 구분자: 쉼표(,)와 콜론(:))
        String delimiter = ",|:";
        if (matcher.group(2) != null) { // 그룹 2가 있으면 커스텀 구분자가 존재
            delimiter = Pattern.quote(matcher.group(2));
        }

        // 2. 숫자 리스트 추출 (세 번째 그룹에서 숫자들을 가져옴)
        String numbers = matcher.group(3);

        // 3. 구분자를 사용해 숫자 분리
        String[] tokens = numbers.split(delimiter);

        return tokens;
    }


}
