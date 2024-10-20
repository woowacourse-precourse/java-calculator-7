package calculator.util.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정수 변환기 테스트")
class IntegerConvertibleTest {

    @Test
    @DisplayName("문자열 리스트가 주어질 때, 정수 리스트로 변환한다")
    void 성공_정수리스트변환_문자열리스트() {
        // Given
        List<String> splitInput = List.of("1", "2", "3");
        IntegerConvertible integerConvertible = new IntegerConvertible();

        // When
        List<Integer> numbers = integerConvertible.convertStringToNumber(splitInput);

        // Then
        assertThat(numbers).containsAll(List.of(1, 2, 3));
    }

}
