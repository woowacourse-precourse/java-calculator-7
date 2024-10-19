package calculator.unit.extractor;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.extractor.CustomDelimitedNumberExtractor;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomDelimiterNumberExtractorTest implements DelimitedNumberExtractorTest {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    @Override
    public ExtractResultTest extract(String input) {
        if (!isCustomDelimiterFormat(input)) {
            return new ExtractResultTest(false, List.of());
        }
        String customDelimiter = extractCustomDelimiter(input);
        String numberString = extractNumberString(input);
        List<String> numbers = splitNumbers(numberString, customDelimiter);
        return new ExtractResultTest(true, numbers);
    }

    private boolean isCustomDelimiterFormat(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return Pattern.quote(input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex));
    }

    private String extractNumberString(String input) {
        int numberStartIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        return input.substring(numberStartIndex);
    }

    private List<String> splitNumbers(String numberString, String delimiter) {
        if (numberString.isEmpty()) {
            return List.of("0");
        }
        return Arrays.stream(numberString.split(delimiter))
                .filter(this::isNumber)
                .collect(Collectors.toList());
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class CustomDelimiterNumberExtractorMethodTest {

    @Test
    @DisplayName("extract 성공 테스트")
    void extract_ok() {
        String input = "//@\\n1@2@3";
        CustomDelimiterNumberExtractorTest customDelimiterNumberExtractor = new CustomDelimiterNumberExtractorTest();
        ExtractResultTest extract = customDelimiterNumberExtractor.extract(input);
        assertEquals(extract.isExtracted(), true);
        assertEquals(extract.getNumbers().get(0), "1");
        assertEquals(extract.getNumbers().get(1), "2");
        assertEquals(extract.getNumbers().get(2), "3");

    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3"})
    @DisplayName("유효한 커스텀 토큰 형식")
    void validCustomTokenFormat(String input) {
        CustomDelimitedNumberExtractor extractor = new CustomDelimitedNumberExtractor();
        assertThatNoException().isThrownBy(() -> extractor.isCustomTokenFormat(input));
    }

}
