package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConverterTest {
    @DisplayName("문자열을 숫자로 변환")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("numbers")
    void convertToInteger(List<String> input, List<Integer> expected) {
        Converter converter = new Converter();
        List<Integer> numbers = converter.convert(input);
        assertEquals(expected, numbers);
    }

    static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3"), List.of(1, 2, 3)),
                Arguments.of(List.of("123"), List.of(123)),
                Arguments.of(List.of("15", "26", "37"), List.of(15, 26, 37))
        );
    }

    @DisplayName("문자열을 정수로 반환 할수 없을 시 예외")
    @Test
    void checkInvalidNumbers() {
        Converter converter = new Converter();
        assertThrows(IllegalArgumentException.class, () -> converter.convert(List.of("1a", "2b", "[3c")));
    }
}