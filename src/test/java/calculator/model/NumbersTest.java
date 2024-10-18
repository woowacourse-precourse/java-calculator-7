package calculator.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 요소를 담는 객체 관련 테스트")
class NumbersTest {

    @Test
    public void 정상적인_계산식_요소화_성공() {
        // given
        String expression = "1:2,3.4[5][]6 7|8";
        Delimiters delimiters = new Delimiters(Set.of(':', ',', '[', ']', ' ', '|'));
        List<String> numbers = List.of("1", "2", "3.4", "5", "6", "7", "8");
        List<BigDecimal> expected = numbers.stream()
                .map(BigDecimal::new)
                .toList();

        // when
        List<BigDecimal> actual = Numbers.of(expression, delimiters).getNumbers();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 숫자의_형식이_올바르지_않은_경우_예외_발생() {
        // given
        String expression = "1:2,33.24.34[5]6 7|8";
        Delimiters delimiters = new Delimiters(Set.of(':', ',', '[', ']', ' ', '|'));

        // when, then
        Assertions.assertThatThrownBy(() -> {
            Numbers.of(expression, delimiters).getNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}