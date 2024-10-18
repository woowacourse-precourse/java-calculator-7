package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Constants {
    // 1. 초기 세팅
    public static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : ";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    public static final Long MAXIMUM_NUMBER = Long.MAX_VALUE;
    public static final String DEFAULT_DELIMITER_PATTERN = DEFAULT_DELIMITER.stream()
            .map(Pattern::quote)
            .collect(Collectors.joining("|"));
    public static final String ERROR_MESSAGE = "입력이 잘못되었습니다";

}
