package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericStringTest {

    @DisplayName("빈 문자열로 NumberString 생성시 에러를 던진다.")
    @Test
    void of() {
        //when //then
        assertThatThrownBy(() -> NumericString.of("", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열 값입니다.");
    }

    @DisplayName("숫자로 이루어진 문자열이 아닌 문자열로 NumberString 생성시 예외가 발생한다.")
    @Test
    void ofWithNonNumericString() {
        //when //then
        assertThatThrownBy(() -> NumericString.of("a123", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("a123은 숫자 형식으로 변환할 수 없는 값입니다.");
    }

    @DisplayName("굉장히 큰 숫자의 덧셈이 가능하다.")
    @Test
    void sum() {
        //given
        NumericString numericString1 = NumericString.of("10000000000000000000000000000000000000000000", 0);
        NumericString numericString2 = NumericString.of("10000000000000000000000000000000000000000000", 0);

        //when
        NumericString result = numericString1.sum(numericString2);

        //then
        assertThat(result.toString()).isEqualTo("20000000000000000000000000000000000000000000");
    }
}