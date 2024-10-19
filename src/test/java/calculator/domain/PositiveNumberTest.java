package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @ValueSource(strings = {"", "0", "1", "999999999999999"})
    @ParameterizedTest(name = "\"{0}\"은 15자리 이하의 양수")
    @DisplayName("양수 생성 성공: 15자리 이하의 양수")
    void 양수_생성_성공(String number) {
        PositiveNumber positiveNumber = createPositiveNumber(number);

        assertThat(positiveNumber).isEqualTo(createPositiveNumber(number));
    }

    @ValueSource(strings = {"-0", "-1", "10l", "1000000000000000"})
    @ParameterizedTest(name = "\"{0}\"은 조건을 만족하지 않는다")
    @DisplayName("양수 생성 실패: 음수, 숫자 외 포함, 15자리 초과 양수")
    void 양수_생성_실패(String number) {
        assertThatThrownBy(() -> createPositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열은 양수 기본값: 0")
    void 빈_문자열은_양수_기본값() {
        PositiveNumber emptyPositiveNumber = createPositiveNumber("");

        assertThat(emptyPositiveNumber).isEqualTo(PositiveNumber.zero());
    }

    @Test
    @DisplayName("두 개의 양수 덧셈 성공")
    void 덧셈_성공() {
        PositiveNumber operand = createPositiveNumber("");
        PositiveNumber otherOperand = createPositiveNumber("1");

        assertThat(operand.add(otherOperand)).isEqualTo(createPositiveNumber("1"));
    }

    @Test
    @DisplayName("두 개의 양수 덧셈 실패: 15자리 초과")
    void 덧셈_실패() {
        PositiveNumber operand = createPositiveNumber("1");
        PositiveNumber otherOperand = createPositiveNumber("999999999999999");

        assertThatThrownBy(() -> operand.add(otherOperand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private PositiveNumber createPositiveNumber(String number) {
        return PositiveNumber.from(number);
    }

}
