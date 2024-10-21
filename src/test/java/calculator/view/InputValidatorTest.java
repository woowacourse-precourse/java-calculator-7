package calculator.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    void testValidatingSeparator_ValidSeparators() {
        List<String> separated = Arrays.asList("1", "+", "2");
        List<String> separators = Arrays.asList("+", "-");

        assertDoesNotThrow(() -> inputValidator.validatingSeparator(separated, separators));
    }

    @Test
    void testValidatingSeparator_InvalidSeparator() {
        List<String> separated = Arrays.asList("1", "/", "2");
        List<String> separators = Arrays.asList("+", "-");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validatingSeparator(separated, separators)
        );
        assertEquals("[ERROR]유효하지 않은 구분자가 사용되었습니다.", exception.getMessage());
    }

    @Test
    void testLastElement_ValidEnding() {
        List<String> separated = Arrays.asList("1", "+", "2");

        assertDoesNotThrow(() -> inputValidator.lastElement(separated));
    }

    @Test
    void testLastElement_InvalidEnding() {
        List<String> separated = Arrays.asList("1", "+");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.lastElement(separated)
        );
        assertEquals("[ERROR]수식이 숫자로 끝나지 않습니다.", exception.getMessage());
    }

    @Test
    void testValidatingFirstLetter_ValidFirstLetter() {
        char firstLetter = '1';

        assertDoesNotThrow(() -> inputValidator.validatingFirstLetter(firstLetter));
    }

    @Test
    void testValidatingFirstLetter_InvalidFirstLetter() {
        char firstLetter = '*';

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validatingFirstLetter(firstLetter)
        );
        assertEquals("[ERROR]수식이 커스텀 구분자 선언자 혹은 숫자로 시작되지 않습니다.", exception.getMessage());
    }

    @Test
    void testCustomValidator_ValidInput() {
        String given = "//;\\n1;2";

        List<String> result = inputValidator.customValidator(given);
        assertEquals(2, result.size());
        assertEquals(";", result.get(0)); // 커스텀 구분자
        assertEquals("1;2", result.get(1)); // 수식
    }

    @Test
    void testCustomValidator_InvalidInputFormat() {
        String given = "//;\\n"; // 수식 없음

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.customValidator(given)
        );
        assertEquals("[ERROR]커스텀 구분자 선언자 뒤에 수식이 숫자로 시작하지 않습니다.", exception.getMessage());
    }

    @Test
    void testCheckContent_ValidCustomSeparator() {
        // 유효한 커스텀 구분자
        String input = "//;\\n1;2";
        List<String> result = inputValidator.customValidator(input);

        assertEquals(";", result.get(0)); // 커스텀 구분자
        assertEquals("1;2", result.get(1)); // 수식
    }

    @Test
    void testCheckContent_EmptyCustomSeparator() {
        // 빈 커스텀 구분자
        String input = "//\\n1;2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.customValidator(input);
        });
        assertEquals("[ERROR]커스텀 구분자 선언자 안에는 한 글자 이상 선언해야 합니다.", exception.getMessage());
    }

    @Test
    void testCheckContent_CustomSeparatorContainsDigit() {
        // 숫자가 포함된 커스텀 구분자
        String input = "//1\\n1;2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.customValidator(input);
        });
        assertEquals("[ERROR]커스텀 구분자 선언자 안에는 숫자가 들어갈 수 없습니다.", exception.getMessage());
    }

    @Test
    void testNotNumAfterCustom_ValidExpression() {
        // 유효한 수식
        String input = "//;\\n1;2";
        List<String> result = inputValidator.customValidator(input);

        assertEquals(";", result.get(0)); // 커스텀 구분자
        assertEquals("1;2", result.get(1)); // 수식
    }

    @Test
    void testNotNumAfterCustom_InvalidExpression() {
        // 커스텀 구분자 뒤에 숫자가 아닌 경우
        String input = "//;\\n;2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.customValidator(input);
        });
        assertEquals("[ERROR]커스텀 구분자 선언자 뒤에 수식이 숫자로 시작하지 않습니다.", exception.getMessage());
    }
}
