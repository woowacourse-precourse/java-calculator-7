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
    @ValueSource(strings = {"1:/,2", "//a\\n1b2:c", "1!2:3"})
    void 지정하지_않은_문자열_예외(String mockInput) {
        var delimiterParser = new DelimiterParser();
        var inputValidator = new InputValidator();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateUnspecifiedCharacters(splitResults);
        });
    }
}

