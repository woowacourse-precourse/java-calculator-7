package calculator.util.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Long 타입 정수 변환기 테스트")
class LongConvertibleTest {

    @Test
    @DisplayName("유효한 수를 포함하는 문자열 리스트가 주어질 때, Long 타입 정수 리스트로 변환한다")
    void 성공_Long타입정수리스트변환_유효한수() {
        // Given
        List<String> splitInput = List.of("1", "2", "3");
        LongConvertible longConvertible = new LongConvertible();

        // When
        List<Long> numbers = longConvertible.convertStringToNumber(splitInput);

        // Then
        assertThat(numbers).containsAll(List.of(1L, 2L, 3L));
    }

    @Test
    @DisplayName("Long 타입 정수 범위에 벗어나는 수를 포함하는 문자열 리스트가 주어질 때, 예외가 발생한다")
    void 성공_Long타입정수리스트변환_범위에벗어나는수() {
        // Given
        List<String> splitInput = List.of(Long.MAX_VALUE + "0" + ",2,3");
        LongConvertible longConvertible = new LongConvertible();

        // When & Then
        Assertions.assertThatThrownBy(() -> longConvertible.convertStringToNumber(splitInput))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("Long 타입 정수로 변환할 수 없는 문자를 포함하는 문자열 리스트가 주어질 때, 예외가 발생한다")
    void 성공_Long타입정수리스트변환_변환불가문자() {
        // Given
        List<String> splitInput = List.of("a", "2", "3");
        LongConvertible longConvertible = new LongConvertible();

        // When & Then
        Assertions.assertThatThrownBy(() -> longConvertible.convertStringToNumber(splitInput))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("소수점을 포함하는 문자열 리스트가 주어질 때, 예외가 발생한다")
    void 성공_Long타입정수리스트변환_소수점() {
        // Given
        List<String> splitInput = List.of("1.5", "2", "3");
        LongConvertible longConvertible = new LongConvertible();

        // When & Then
        Assertions.assertThatThrownBy(() -> longConvertible.convertStringToNumber(splitInput))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("음수를 포함하는 문자열 리스트가 주어질 때, 예외가 발생한다")
    void 성공_Long타입정수리스트변환_음수() {
        // Given
        List<String> splitInput = List.of("-1", "2", "3");
        LongConvertible longConvertible = new LongConvertible();

        // When & Then
        Assertions.assertThatThrownBy(() -> longConvertible.convertStringToNumber(splitInput))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수가 아닙니다.");
    }

}
