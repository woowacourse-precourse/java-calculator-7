package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorExtractor {

    private final String regex;


    //테스트환경에서는 \n가 문자열로 인식되지만 실제 런타입에서는 개행문자로 인식되는 문제가 있어 정규식을 상황에 맞게 받도록함
    public SeparatorExtractor(String regex) {
        this.regex = regex;
    }

    public String extractCustomSeparator(String value, List<String> customSeparators) {
        if (!value.contains("//")) {
            return value;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            //커스텀 구분자 추출
            String separator = matcher.group(1);

            //커스텀 구분자에 양수가 포함되면 예외 발생
            boolean isNumContains = separator.chars().anyMatch(c -> c >= '1' && c <= '9');
            if (isNumContains) {
                throw new IllegalArgumentException("커스텀 구분자에는 양수가 포함될 수 없습니다.");
            }

            //구분자 리스트에 추출한 커스텀 구분자 추가
            customSeparators.add(separator);
        }

        // 커스텀 구분자 선언이 추출되고 남은 문자열 반환
        return matcher.replaceAll("").trim();
    }
}
