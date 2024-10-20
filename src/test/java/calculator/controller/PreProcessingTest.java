package calculator.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreProcessingTest {
    private final Preprocessing preprocessing = new Preprocessing();

    @Test
    void testProcessInput_WithCustomSeparator() {
        String input = "//;\\n1;2;3"; // 커스텀 구분자 사용
        List<String> result = preprocessing.processInput(input);

        assertEquals(Arrays.asList("1", ";", "2", ";", "3"), result);
    }

    @Test
    void testProcessInput_WithoutCustomSeparator() {
        String input = "1,2:3"; // 기본 구분자 사용
        List<String> result = preprocessing.processInput(input);

        assertEquals(Arrays.asList("1", ",", "2", ":", "3"), result);
    }

    @Test
    void testProcessInput_InvalidCustomSeparator() {
        String input = "//\\n1;2"; // 빈 커스텀 구분자

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            preprocessing.processInput(input);
        });
        assertEquals("[ERROR]커스텀 구분자 선언자 안에는 한 글자 이상 선언해야 합니다.", exception.getMessage());
    }

    @Test
    void testProcessInput_CustomSeparatorWithDigit() {
        String input = "//1\\n1;2"; // 숫자가 포함된 커스텀 구분자

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            preprocessing.processInput(input);
        });
        assertEquals("[ERROR]커스텀 구분자 선언자 안에는 숫자가 들어갈 수 없습니다.", exception.getMessage());
    }

    @Test
    void testProcessInput_LastElementNotNumber() {
        String input = "//;\\n1;2;"; // 마지막 요소가 숫자가 아닌 경우

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            preprocessing.processInput(input);
        });
        assertEquals("[ERROR]수식이 숫자로 끝나지 않습니다.", exception.getMessage());
    }

    @Test
    void testProcessInput_ValidExpressionWithoutCustomSeparator() {
        String input = "1:2,3"; // 기본 구분자 사용
        List<String> result = preprocessing.processInput(input);

        assertEquals(Arrays.asList("1", ":", "2", ",", "3"), result);
    }
}
