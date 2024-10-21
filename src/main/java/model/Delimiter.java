package model;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {
    private static final int DELIMITER_LENGTH = 1;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern SINGLE_NUMERIC_PATTERN = Pattern.compile("\\d");

    private final String input;

    private Delimiter(String input) {
        validateLength(input);
        validateDelimiterCharacter(input);

        this.input = input;
    }

    // 구분자의 길이를 확인하는 함수
    private void validateLength(String input) {
        if (input.isBlank() || input.length() > DELIMITER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH_EXCEEDS_ONE.getMessage());
        }
    }

    private void validateDelimiterCharacter(String input) {
        if (SINGLE_NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_TYPE.getMessage());
        }
    }

    /**
     * 기본 구분자를 반환하는 메서드 (Delimiter 객체 리스트로)
     **/
    public static List<Delimiter> getDefaultDelimiter() {
        List<Delimiter> delimiters = new ArrayList<>();
        // 기본 구분자 (",", ":")를 Delimiter 객체로 변환하여 리스트에 추가
        Arrays.asList(DEFAULT_DELIMITER.split("\\|")).forEach(delim -> delimiters.add(new Delimiter(delim)));
        return delimiters;
    }

    /**
     * 문자열을 Delimiter 객체로 변환하는 정적 메서드
     **/
    public static Delimiter from(String delimiter) {
        return new Delimiter(delimiter);
    }

    public static String toRegex(List<Delimiter> delimiters) {
        return delimiters.stream()
                .map(delim -> Pattern.quote(delim.input))  // 구분자 값을 안전하게 사용하기 위해 quote 처리
                .reduce((d1, d2) -> d1 + "|" + d2)
                .orElse(DEFAULT_DELIMITER); // 기본 구분자를 기본값으로 사용
    }
}
