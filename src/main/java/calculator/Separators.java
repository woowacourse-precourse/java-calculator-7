package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Separators {

    private final Set<Separator> separators = new HashSet<>(Set.of(
            new Separator(','),
            new Separator(':')));


    public void add(Separator separator) {
        separators.add(separator);
    }

    // 입력 문자열을 구분자로 분리하는 메서드
    public List<String> separate(String input) {
        // 구분자를 결합하여 하나의 정규식으로 변환
        StringBuilder regexBuilder = createRegexBuilder();

        // 입력 문자열을 구분자 기준으로 분리
        return Arrays.stream(input.split(regexBuilder.toString()))
                .map(String::trim)
                .toList();
    }

    private StringBuilder createRegexBuilder() {
        StringBuilder regexBuilder = new StringBuilder();
        for (Separator separator : separators) {
            if (!regexBuilder.isEmpty()) {
                regexBuilder.append("|"); // OR 연산자 추가
            }
            // 구분자가 특수 문자일 경우를 대비해 이스케이프 처리
            String quote = Pattern.quote(separator.toString());
            regexBuilder.append(quote);
        }
        return regexBuilder;
    }
}
