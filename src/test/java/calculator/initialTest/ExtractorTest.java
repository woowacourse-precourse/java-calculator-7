package calculator.initialTest;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtractorTest {
    CustomExtractor customExtractor;

    @BeforeEach
    void beforeEach() {
        customExtractor = new CustomExtractor();
    }

    @Test
    void 기본구분자추출기_추출() {
        String input = "1,2:3";
        String[] inputSplit = input.split(",|:");
        String[] expected = new String[]{"1", "2", "3"};
        Assertions.assertArrayEquals(inputSplit, expected);
    }


    @Test
    void 커스텀구분자추출기_추출() {
        String input = "//;\\n1;2;3";// //;as\\\\\n1;as\\\\2;as\\\\37
        String customDelimiter = customExtractor.extractCustomDelimiter(input);
        String expected = ";";
        expected = Pattern.quote(expected);
        Assertions.assertEquals(expected, customDelimiter);

    }

    @ParameterizedTest
    @CsvSource({
            " '//;\\n1;2;3',';'  ",
            " '//;as\\\\\\n1;as\\\\2;as\\\\37', ';as\\\\'   "
    })
    void 커스텀구분자추출기_추출_여러케이스(String input, String expected) {
        String customDelimiter = customExtractor.extractCustomDelimiter(input);

        expected = Pattern.quote(expected);
        Assertions.assertEquals(expected, customDelimiter);

    }


}


class CustomExtractor {

    public String extractCustomDelimiter(String input) {
        String[] firstSecondInput = input.split("\\\\n");

        String firstInput = firstSecondInput[0];
        String delimiter = firstInput.substring(2);
        delimiter = checkEscape(delimiter);
        return delimiter;
    }

    private String checkEscape(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }


}
