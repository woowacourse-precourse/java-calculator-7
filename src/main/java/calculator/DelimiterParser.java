package calculator;

import java.util.Optional;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final String DEFAULT_DELIMITER = "[,:]";

    /**
     * 주어진 문자열을 내용과 구분자로 분리한다.
     *
     * <p>기본 구분자로 {@code ','와 ':'}를 제공한다.
     * 새로운 구분자를 추가하기 위해서 {@code "//[delimiter]\n[content]"}과 같이 문자열을 입력할 수 있다.</p>
     * @param str 분석할 문자열
     * @return 내용과 구분자를 전달하는 DelimiterContentPair 객체.
     * @throws IllegalArgumentException 개행문자 '\n'이 없거나 커스텀 구분자가 입력되지 않은 경우.
     */
    public DelimiterContentPair parseInput(String str) {
        return extractCustomDelimiter(str)
                .orElse(new DelimiterContentPair(str, DEFAULT_DELIMITER));
    }

    private Optional<DelimiterContentPair> extractCustomDelimiter(String str) {
        if (str.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String[] substr = str.split(CUSTOM_DELIMITER_SUFFIX, 2);
            String addedDelimiter = substr[0].substring(2);

            if (substr.length == 1 || addedDelimiter.isEmpty()) {
                throw new IllegalArgumentException("Invalid input: ");
            }

            String customDelimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(addedDelimiter);
            return Optional.of(new DelimiterContentPair(substr[1], customDelimiter));
        }
        return Optional.empty();
    }
}