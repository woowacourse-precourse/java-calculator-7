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

@DisplayName("정수 가산기 테스트")
class IntegerAdderTest {

    @Test
    @DisplayName("정수들을 더한다")
    void 성공_정수가산_오버플로우X() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3);
        IntegerAdder integerAdder = new IntegerAdder();

        // When
        Integer sum = integerAdder.addNumbers(numbers);

        // Then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("정수들을 더할 때, 오버플로우가 발생할 경우 예외가 발생한다")
    void 성공_정수가산_오버플로우O(List<Integer> numbers) {
        // Given
        IntegerAdder integerAdder = new IntegerAdder();

        // When & Then
        assertThatThrownBy(() -> integerAdder.addNumbers(numbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("오버플로우가 발생했습니다.");
    }

    private static Stream<Arguments> 성공_정수가산_오버플로우O() {
        return Stream.of(
                Arguments.of(List.of((int) (Math.pow(2, 31) - 1), 2, 3)),
                Arguments.of(List.of((int) -Math.pow(2, 31), -2, -3))
        );
    }

}
