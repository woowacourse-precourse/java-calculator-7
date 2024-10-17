package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    static final int MAX_NUMBER_DIGITS = 30;

    @Test
    @DisplayName("숫자의 기본 값은 0이여야 한다.")
    void defaultNumberZeroTest() {
        // given
        Number zero = Number.ofZero();

        // then
        assertThat(zero).isEqualTo(Number.of("0"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2", " 12", "12 ", "1a2", "1-2", "", " "})
    @DisplayName("숫자가 아닌 다른 형식이라면 예외가 발생해야 한다.")
    void invalidNumberFormatExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> Number.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("값이 동일하면 같은 숫자여야 한다.")
    void equalsTest() {
        // given
        String originValue = "123";
        String compareValue = "123";

        Number originNumber = Number.of(originValue);
        Number compareNumber = Number.of(compareValue);

        // then
        assertThat(originNumber).isEqualTo(compareNumber);
    }

    @Test
    @DisplayName("숫자가 음수라면 예외가 발생해야 한다.")
    void negativeNumberExceptionTest() {
        // given
        String negativeValue = "-123";

        // when, then
        assertThatThrownBy(() -> Number.of(negativeValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 최대 자릿수를 초과하면 예외가 발생해야 한다.")
    void outOfMaxDigitsExceptionTest() {
        // given
        String bigDigitsValue = "1".repeat(MAX_NUMBER_DIGITS + 1);

        // when, then
        assertThatThrownBy(() -> Number.of(bigDigitsValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자에 0을 더하면 동일한 숫자여야 한다.")
    void plusZeroTest() {
        // given
        String value = "1";
        Number number = Number.of(value);
        Number zero = Number.ofZero();

        // when
        number.plus(zero);

        // then
        assertThat(number).isEqualTo(Number.of(value));
    }

    @Test
    @DisplayName("숫자에 숫자를 더하면 합한 숫자여야 한다.")
    void plusNumberTest() {
        // given
        String value = "1";
        String addValue = "99";
        Number number = Number.of(value);
        Number addNumber = Number.of(addValue);

        // when
        number.plus(addNumber);

        // then
        assertThat(number).isEqualTo(Number.of("100"));
    }

    @Test
    @DisplayName("합한 숫자가 최대 자릿수를 초과하면 예외가 발생해야 한다.")
    void plusNumberOutOfMaxDigitsExceptionTest() {
        // given
        String oneValue = "1";
        String bigDigitsValue = "9".repeat(MAX_NUMBER_DIGITS);
        Number one = Number.of(oneValue);
        Number maxNumber = Number.of(bigDigitsValue);

        // when, then
        assertThatThrownBy(() -> one.plus(maxNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
