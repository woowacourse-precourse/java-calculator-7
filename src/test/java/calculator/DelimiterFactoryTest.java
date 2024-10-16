package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterFactoryTest {

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    @ParameterizedTest
    @MethodSource("provideDelimiterTestCases")
    @DisplayName("입력에 따라 적절한 구분자를 반환한다.")
    void testGetDelimiter(String input, String expectedClassName) {
        Delimiter delimiter = delimiterFactory.getDelimiter(input);
        String delimiterClassName = delimiter.getClass().getSimpleName();

        assertThat(delimiterClassName).isEqualTo(expectedClassName);
    }

    @Test
    @DisplayName("구분자가 적절하지 않은 경우 예외가 발생한다.")
    void testGetDelimiter_InvalidInput() {
        String invalidInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterFactory.getDelimiter(invalidInput);
        });

        assertThat(exception.getMessage()).isEqualTo("구분자가 적절하지 않다.");
    }

    // 메서드 소스 제공
    private static Stream<Arguments> provideDelimiterTestCases() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", "CustomDelimiter"),   // 커스텀 구분자
                Arguments.of("1,2,3", "RegularDelimiter"),       // 정규 구분자 (쉼표)
                Arguments.of("4:5:6", "RegularDelimiter"),       // 정규 구분자 (콜론)
                Arguments.of("1", "DefaultDelimiter"),           // 디폴트 구분자 (단일 숫자)
                Arguments.of(" ", "DefaultDelimiter")            // 디폴트 구분자 (공백)
        );
    }
}
