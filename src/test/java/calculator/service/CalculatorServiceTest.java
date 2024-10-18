package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @DisplayName("커스텀 구분자가 존재하는 경우")
    @Test
    void isCustomDelimiterTrue() {

        //given
        String inputString = "//*\n1*2*3";

        //when
        boolean result = calculatorService.isCustomDelimiter(inputString);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("구분자가 존재하지 않는 경우")
    @Test
    void isCustomDelimiterFalse() {

        //given
        String inputString = "1*2*3";

        //when
        boolean result = calculatorService.isCustomDelimiter(inputString);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("커스텀 구분자를 파싱하는 테스트")
    @Test
    void parseCustomDelimiter() {

        //given
        String inputString = "//*\n1*2*3";

        //when
        String delimiter = calculatorService.parseCustomDelimiter(inputString);

        //then
        assertThat(delimiter).isEqualTo("*");
    }

    @DisplayName("커스텀 구분자 길이 검증 성공 테스트")
    @Test
    void checkDelimiterLength() {

        //given
        String delimiter = "^";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterLength(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 길이 검증 실패 테스트")
    @Test
    void checkDelimiterLengthException() {

        //given
        String delimiter = "^_^";

        //when - then
        assertThatThrownBy(() -> calculatorService.checkDelimiterLength(delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 숫자 유무 검증 성공 테스트")
    @Test
    void checkDelimiterIsNumber() {

        //given
        String delimiter = "&";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterIsNumber(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 숫자 유무 검증 실패 테스트")
    @Test
    void checkDelimiterIsNumberException() {

        //given
        String delimiter = "6";

        //when - then
        assertThatThrownBy(() -> calculatorService.checkDelimiterIsNumber(delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 +, - 부호 유무 검증 성공 테스트")
    @Test
    void checkDelimiterPlusMinus() {

        //given
        String delimiter = "%";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterPlusMinus(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 +, - 부호 유무 검증 실패 테스트")
    @Test
    void checkDelimiterPlusMinusException() {

        //given
        String delimiterPlus = "+";
        String delimiterMinus = "-";

        //when
        assertThatThrownBy(() -> calculatorService.checkDelimiterPlusMinus(delimiterPlus))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculatorService.checkDelimiterPlusMinus(delimiterMinus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자 셋 테스트")
    @Test
    void setDelimiter() {
        //given
        String customDelimiter = "$";
        String inputString = "//" + customDelimiter + "\n1&2&3";

        //when
        List<String> delimiters = calculatorService.setDelimiter(inputString);

        //then
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.contains(customDelimiter)).isTrue();
    }


}