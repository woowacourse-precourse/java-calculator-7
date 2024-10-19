package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("기본 구분자인 , : 를 사용 시 합이 정상적으로 출력")
    void defaultConvert() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.convert("3,3:3");
        //then
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("기본 구분자가 아닌 다른 구분자 사용 시 에러 발생")
    void defaultConvertError() {
        // given
        Calculator calculator = new Calculator();
        // when

        // then
        Assertions.assertThatThrownBy(() -> calculator.convert("3,3;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다, 구분자로 \",\" 나 \":\" 를 사용하세요");
    }
}