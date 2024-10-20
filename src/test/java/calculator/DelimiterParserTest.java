package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterParserTest {

    @Test
    void 커스텀_구분자가_없는_경우_문자_분리() {
        String mockInput = "1,2:3";
        String[] result = {"1", "2", "3"};

        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);

        assertArrayEquals(result, splitResults);
    }

    @Test
    void 커스텀_구분자가_있는_경우_문자_분리() {
        String mockInput = "//a\\n1a2a3:4";
        String[] result = {"1", "2", "3", "4"};

        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);

        assertArrayEquals(result, splitResults);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/", "!", "a"})
    void 지정하지_않은_문자열_예외(String mockInput) {
        var inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateUnspecifiedCharacters(mockInput);
        });
    }

    @Test
    void 분리된_문자열을_숫자로_변환() {
        String[] mockSplitResults = {"1", "23", "4"};
        int[] expectedResults = {1, 23, 4};

        var delimiterParser = new DelimiterParser();
        int[] actualResults = new int[mockSplitResults.length];

        for (int i = 0; i < mockSplitResults.length; i++) {
            actualResults[i] = delimiterParser.convertToNumber(mockSplitResults[i]);
        }

        assertArrayEquals(expectedResults, actualResults);
    }

}

