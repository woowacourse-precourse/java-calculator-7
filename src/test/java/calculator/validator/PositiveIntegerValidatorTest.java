package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class PositiveIntegerValidatorTest {

    @Test
    void 음수_포함_시_예외_발생() {
        List<String> numbers = List.of("-1", "0", "3", "22");

        assertThatThrownBy(() -> PositiveIntegerValidator.validatePositiveIntegers(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("음수는 허용되지 않습니다.");
    }

    @Test
    void 잘못된_숫자_형식_예외_발생_1() {
        List<String> numbers = List.of("a", "2", "23", "4");

        assertThatThrownBy(() -> PositiveIntegerValidator.validatePositiveIntegers(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    void 잘못된_숫자_형식_예외_발생_2() {
        List<String> numbers = List.of("2", ")", "23", "4");

        assertThatThrownBy(() -> PositiveIntegerValidator.validatePositiveIntegers(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    void 양수_검증_성공() {
        List<String> numbers = List.of("1", "23", "34", "2");

        assertThatCode(() -> PositiveIntegerValidator.validatePositiveIntegers(numbers)).doesNotThrowAnyException();
    }
}