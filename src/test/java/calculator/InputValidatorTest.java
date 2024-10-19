package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    private final InputStream originalIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\\na//1:2,3", "//aa\\n1:2,3"})
    void 커스텀_구분자_형식(String mockInput) {
        int customDelimiterStartIndex = mockInput.indexOf("//") + 2;
        int customDelimiterEndIndex = mockInput.indexOf("\\n") - 1;

        var inputValidator = new InputValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCustomDelimiterFormat(customDelimiterStartIndex, customDelimiterEndIndex);
        });
    }
}
