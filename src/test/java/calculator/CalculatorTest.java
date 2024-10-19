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

    @Test
    @DisplayName("커스텀한 구분자를 하나만 설정하고 사용 시 합이 정상적으로 출력")
    void customConvert() {
        // given
        Calculator calculator = new Calculator();
        // when
        int result = calculator.convert("//;\n3;3;3");
        // then
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("커스텀한 구분자를 여러 개 설정하고 사용 시 합이 정상적으로 출력")
    void multiCustomConvert() {
        // given
        Calculator calculator = new Calculator();
        // when
        int result = calculator.convert("//;j\n3;3j3");
        // then
        Assertions.assertThat(result).isEqualTo(9);
    }


    @Test
    @DisplayName("커스텀 구분자 양식을 지키지 않았을 때 에러 발생")
    void customConvertError() {
        // given
        Calculator calculator = new Calculator();
        // when

        // then
        Assertions.assertThatThrownBy(() -> calculator.convert("//s\\3,3;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식입니다, 커스텀 구분자를 \"\\\" \"\n\" 사이에 넣으세요");
    }

    @Test
    @DisplayName("커스텀 구분자 설정 후 다른 구분자를 사용하였을 때 에러 발생")
    void customConvertError2() {
        // given
        Calculator calculator = new Calculator();
        // when

        // then
        Assertions.assertThatThrownBy(() -> calculator.convert("//s\n3,3;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다, 설정한 구분자를 사용하세요");
    }

}