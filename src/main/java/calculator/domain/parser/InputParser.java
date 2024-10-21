package calculator.domain.parser;

import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COLON;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COMMA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class InputParser {

    /**
     * 주어진 입력 문자열을 분석하고, 구분자를 기준으로 숫자들을 추출한 후 {@link ParsedInput} 객체로 반환합니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 숫자 토큰을 포함한 {@link ParsedInput} 객체
     */
    public ParsedInput parse(String input) {
        Set<String> delimiters = initializeDefaultDelimiters();
        String stringNumbers = input;

        if (containCustomDelimiter(input)) {
            stringNumbers = processCustomDelimiter(input, delimiters);
        }

        String[] numbersTokens = tokenizeNumbers(stringNumbers, delimiters);

        return new ParsedInput(numbersTokens);
    }

    /**
     * 기본 구분자(쉼표와 콜론)를 초기화합니다.
     *
     * @return 기본 구분자들을 포함한 `Set` 객체
     */
    private Set<String> initializeDefaultDelimiters() {
        Set<String> delimiters = new HashSet<>();
        delimiters.add(DEFAULT_DELIMITER_COLON.getValue());
        delimiters.add(DEFAULT_DELIMITER_COMMA.getValue());

        return delimiters;
    }

    /**
     * 입력 문자열에서 커스텀 구분자를 추출하고, 숫자 부분을 반환합니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @param delimiters 구분자 집합
     * @return 숫자만 남은 문자열
     */
    private String processCustomDelimiter(String input, Set<String> delimiters) {
        int lastDelimiterIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX.getValue());

        String customDelimiterSection = input.substring(2, lastDelimiterIndex);
        String numbers = input.substring(lastDelimiterIndex + 2);

        delimiters.addAll(extractCustomDelimiters(customDelimiterSection));

        return numbers;
    }

    /**
     * 숫자 문자열을 주어진 구분자들을 기준으로 토큰화합니다.
     *
     * @param numbers 숫자 문자열
     * @param delimiters 사용할 구분자들의 집합
     * @return 구분된 숫자 토큰 배열
     */
    private String[] tokenizeNumbers(String numbers, Set<String> delimiters) {
        String regex = String.join("|", delimiters);
        String[] numbersTokens = numbers.split(regex);

        return filterEmptyString(numbersTokens);
    }

    /**
     * 빈 문자열 토큰을 제거한 배열을 반환합니다.
     *
     * @param numbers 토큰화된 숫자 배열
     * @return 빈 문자열을 제거한 숫자 배열
     */
    private String[] filterEmptyString(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(Predicate.not(String::isEmpty))
                .toArray(String[]::new);
    }

    /**
     * 커스텀 구분자 섹션에서 구분자들을 추출합니다.
     *
     * @param customDelimiterSection 커스텀 구분자 섹션
     * @return 추출된 구분자들을 포함한 `Set` 객체
     */
    private Set<String> extractCustomDelimiters(String customDelimiterSection) {
        Set<String> delimiters = new HashSet<>();

        for (char ch : customDelimiterSection.toCharArray()) {
            delimiters.add(Pattern.quote(String.valueOf(ch)));
        }

        return delimiters;
    }

    /**
     * 입력 문자열이 커스텀 구분자를 포함하고 있는지 확인합니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 커스텀 구분자가 포함되어 있으면 true, 그렇지 않으면 false
     */
    public boolean containCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue())
                && input.contains(CUSTOM_DELIMITER_SUFFIX.getValue());
    }

    public record ParsedInput(String[] numbersToken) { }

}
