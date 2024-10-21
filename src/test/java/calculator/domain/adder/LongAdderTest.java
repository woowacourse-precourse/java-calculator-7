package calculator.domain.adder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Long 타입 가산기 테스트")
class LongAdderTest {

    @Test
    @DisplayName("Long 타입 정수들을 더한다")
    void 성공_Long타입정수가산_오버플로우X() {
        // Given
        List<Long> numbers = List.of(1L, 2L, 3L);
        LongAdder longAdder = new LongAdder();

        // When
        Long sum = longAdder.addNumbers(numbers);

        // Then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Long 타입 정수들을 더할 때, 오버플로우가 발생할 경우 예외가 발생한다")
    void 성공_Long타입정수가산_오버플로우O(List<Long> numbers) {
        // Given
        LongAdder longAdder = new LongAdder();

        // When & Then
        assertThatThrownBy(() -> longAdder.addNumbers(numbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("오버플로우가 발생했습니다.");
    }

    private static Stream<Arguments> 성공_Long타입정수가산_오버플로우O() {
        return Stream.of(
                Arguments.of(List.of((long) (Math.pow(2, 63) - 1), 2L, 3L)),
                Arguments.of(List.of((long) -Math.pow(2, 63), -2L, -3L))
        );
    }

}
