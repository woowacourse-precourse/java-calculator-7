package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DigitExtractor {

    private List<String> tokens = new ArrayList<>(); // 구분자 기준으로 분리한 문자열 토큰

    /**
     * TODO 문자열에서 숫자 추출
     */
    public List<Integer> extractDigits(String input) {
        return null;
    }

    /**
     * 문자열의 유효성 검증
     */
    public boolean isValidateInput(String input) {
        if (input.startsWith("//")) { // TODO 커스텀 구분자 사용
            char customDelimiter = input.charAt(3);
            if (input.charAt(4) != '\n' || customDelimiter == ' '
                    || Character.getNumericValue(customDelimiter) != -1) {
                return false;
            }
            String regex = "[,:]" + "|" + Pattern.quote(Character.toString(customDelimiter));
            tokens = List.of(input.split(regex));
        } else { // 기본 구분자만 사용
            tokens = Stream.of(input.split("[,:]")).map(String::trim).collect(Collectors.toList());
        }

        return tokens.stream().noneMatch(token -> token.trim().matches(".*[^0-9].*"));
    }

}
