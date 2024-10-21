package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DelimiterExtractorTest {

    private DelimiterExtractor extractor;

    @BeforeEach
    void setUp() {
        extractor = new DelimiterExtractor();
    }

    private List<String> getSortedDelimiters(String regex) {
        return Arrays.stream(regex.split("\\|"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Test
    void 기본_구분자_추출_테스트() {
        String regex = extractor.generateDelimiterRegex("1,2:3");
        List<String> sortedDelimiters = getSortedDelimiters(regex);
        assertEquals(Arrays.asList(",", ":"), sortedDelimiters);
    }

    @Test
    void 커스텀_구분자_추출_테스트() {
        String regex = extractor.generateDelimiterRegex("//#\\n1#2#3");
        List<String> sortedDelimiters = getSortedDelimiters(regex);
        assertEquals(Arrays.asList(",", ":", "\\Q#\\E"), sortedDelimiters);
        assertEquals("1#2#3", extractor.getExpression());
    }

    @Test
    void 여러개의_커스텀_구분자_추출_테스트() {
        String regex = extractor.generateDelimiterRegex("//#\\n//$\\n1#2$3");
        List<String> sortedDelimiters = getSortedDelimiters(regex);
        assertEquals(Arrays.asList(",", ":", "\\Q#\\E", "\\Q$\\E"), sortedDelimiters);
        assertEquals("1#2$3", extractor.getExpression());
    }

    @Test
    void 긴_커스텀_구분자_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.generateDelimiterRegex("//qq\\n1qq2qq3"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 1글자의 문자만 가능합니다.", exception.getMessage());
    }

    @Test
    void 숫자_구분자_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.generateDelimiterRegex("//1\\n213"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 숫자 형식이 불가합니다.", exception.getMessage());
    }

    @Test
    void 빈_문자열_구분자_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.generateDelimiterRegex("//\\n123"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 빈 문자열이 불가합니다.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "////\\n1//2//3",
            "//\\n\\n1\\n2\\n3",
            "//\\n\\n////\\n1//2\\n3",
            "////\\n\\n//$\\n////\\n1//2\\n3$4,5",
            "//////\\n\\n\\n1////\\n\\n2"
    })
    void 커스텀_구분자_포맷_예외_테스트(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.generateDelimiterRegex(input));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 '//'와 '\\n' 사이에 위치해야 합니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_위치_예외_처리_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.generateDelimiterRegex("//;\\n1;2;//$\\n4$4"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 문자열 맨 앞에 정의해야 합니다.", exception.getMessage());
    }
}
