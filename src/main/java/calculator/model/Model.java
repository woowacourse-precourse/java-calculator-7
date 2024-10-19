package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {

    // 커스텀 구분자 추출 정규식 패턴
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 덧셈 계산 메소드
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0; // 입력이 비어있는 경우 0 반환

        String delimiters = DEFAULT_DELIMITERS;
        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
            if (!matcher.find()) throw new IllegalArgumentException("잘못된 입력 형식입니다.");

            delimiters += "|" + Pattern.quote(matcher.group(1));
            input = matcher.group(2); // 커스텀 구분자 이후의 숫자 추출
        }

        return sum(input.split(delimiters)); // 숫자를 구분자로 분리 후 덧셈
    }

    // 숫자를 모두 더하는 메소드
    private int sum(String[] numbArr) {
        int result = 0;
        for (String num : numbArr) {
            int n = Integer.parseInt(num);
            if (n < 0) throw new IllegalArgumentException("음수는 입력할 수 없습니다."); // 음수 예외처리

            result += n;
        }
        return result;
    }
}
