package calculator.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @DisplayName("양수 생성 성공: 15자리 이하의 양수")
    @ValueSource(strings = {"", "0", "1", "999999999999999"})
    @ParameterizedTest(name = "\"{0}\"은 15자리 이하의 양수")
    void 양수_생성_성공(String number) {
        PositiveNumber positiveNumber = createPositiveNumber(number);

        assertThat(positiveNumber).isEqualTo(createPositiveNumber(number));
    }

    @DisplayName("양수 생성 실패: 음수, 숫자 외 포함, 15자리 초과 양수")
    @CsvSource(value = {
            "-0,0(or 빈 문자)을 포함한 양수를 +없이 입력해 주세요.",
            "-1,0(or 빈 문자)을 포함한 양수를 +없이 입력해 주세요.",
            "10l,구분자를 제외한 입력은 숫자만 입력해 주세요.",
            "1000000000000000,15자리를 초과한 양수는 계산할 수 없습니다."
    })
    @ParameterizedTest(name = "\"{0}\"은 조건을 만족하지 않는다")
    void 양수_생성_실패(String number, String expectedErrorMessage) {
        assertThatThrownBy(() -> createPositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("빈 문자열은 양수 기본값: 0")
    @Test
    void 빈_문자열은_양수_기본값() {
        PositiveNumber emptyPositiveNumber = createPositiveNumber("");

        assertThat(emptyPositiveNumber).isEqualTo(PositiveNumber.zero());
    }

    @DisplayName("두 개의 양수 덧셈 성공")
    @Test
    void 덧셈_성공() {
        PositiveNumber operand = createPositiveNumber("");
        PositiveNumber otherOperand = createPositiveNumber("1");

        assertThat(operand.add(otherOperand)).isEqualTo(createPositiveNumber("1"));
    }

    @DisplayName("두 개의 양수 덧셈 실패: 15자리 초과")
    @Test
    void 덧셈_실패() {
        PositiveNumber operand = createPositiveNumber("1");
        PositiveNumber otherOperand = createPositiveNumber("999999999999999");

        assertThatThrownBy(() -> operand.add(otherOperand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("15자리를 초과한 양수는 계산할 수 없습니다.");
    }

    private PositiveNumber createPositiveNumber(String number) {
        return PositiveNumber.from(number);
    }

}
