package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    private final InputStream originalIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 커스텀_구분자_형식() {
        String[] mockInputs = {
                "//aa\n1:2,3",
                "\na//1:2,3"
        };
        var runner = new InputHandler();

        for (String mockInput : mockInputs) {
            System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

            String userInput = runner.readInput();

            int customDelimiterStartIndex = userInput.indexOf("//") + 2;
            int customDelimiterEndIndex = userInput.indexOf("\\n") - 1;
            var inputValidator = new InputValidator();

            assertThrows(IllegalArgumentException.class, () -> {
                inputValidator.validateCustomDelimiterFormat(customDelimiterStartIndex, customDelimiterEndIndex);
            });
        }

    }
}
