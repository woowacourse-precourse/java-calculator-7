package calculator.delimiterExtractor;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DelimiterExtractorTest {

    CustomDelimiterExtractor customDelimiterExtractor;
    DefaultDelimiterExtractor defaultDelimiterExtractor;


    @BeforeEach
    @Test
    void beforeEach() {
        customDelimiterExtractor = new CustomDelimiterExtractor();
        defaultDelimiterExtractor = new DefaultDelimiterExtractor();

    }

    @Test
    void 기본구분자추출() {
        String extractDelimiter = defaultDelimiterExtractor.extractDelimiter("1,2:3");
        String expected = ",|:";
        Assertions.assertEquals(expected, extractDelimiter);
    }


    @Test
    void 커스텀구분자추출() {
        String extractDelimiter = customDelimiterExtractor.extractDelimiter("//;\\n1;2;3");
        String expected = ";";
        expected = Pattern.quote(expected);
        Assertions.assertEquals(expected, extractDelimiter);
    }


    @ParameterizedTest
    @CsvSource({
            " '//;\\n1;2;3',   ';'  ",
            " '//;as\\\\\\n1;as\\\\2;as\\\\37', ';as\\\\'   ",
            "  '//;+3{\\n1;+3{2;+3{37'    , ';+3{'   ",
            "  '//;\\+{2}\\n1;\\+{2}2;\\+{2}3'    , ';\\+{2}'   "
    })
    void 커스텀구분자추출_여러개(String input, String expected) {
        String extractDelimiter = customDelimiterExtractor.extractDelimiter(input);
        expected = Pattern.quote(expected);

        System.out.println("extractDelimiter = " + extractDelimiter);
        System.out.println("expected = " + expected);

        Assertions.assertEquals(expected, extractDelimiter);
    }


    @Test
    void 이스케이프_적용안될경우_테스트_정규식의의미반영됨_문자그대로해석X() {
        String delimiter = "a+";
        String input = "1aa2aaa3aaaa4";
        String[] split = input.split(delimiter);
        String[] ex = new String[]{"1", "2", "3", "4"};
        Assertions.assertArrayEquals(split, ex);
    }

    @Test
    void 이스케이프_적용될경우_테스트_정규식의미반영안됨_문자그대로해석O() {
        String delimiter = "a+";
        String input = "1a+2a+3a+4";
        delimiter = Pattern.quote(delimiter);
        String[] split = input.split(delimiter);
        String[] ex = new String[]{"1", "2", "3", "4"};

        Assertions.assertArrayEquals(split, ex);

    }
}
