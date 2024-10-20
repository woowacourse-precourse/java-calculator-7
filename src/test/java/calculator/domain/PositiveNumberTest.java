package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"})
    @DisplayName("PositiveNumber 정상 생성 테스트")
    void testPositiveNumberSuccess(String numberString) {
        // given
        PositiveNumber positiveNumber = new PositiveNumber(numberString);
        int expected = Integer.parseInt(numberString);

        // when
        int actual = positiveNumber.getNumber();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "-1", "3.14", "9999999999"})
    @DisplayName("PositiveNumber 생성 빈 문자열, 양수, Integer 범위 초과 테스트")
    void testPositiveNumberFail(String numberString) {
        // when then
        Assertions.assertThatThrownBy(() -> new PositiveNumber(numberString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}