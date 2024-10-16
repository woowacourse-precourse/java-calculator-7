package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void getCustomDivisionMark() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDivisionMark = "//|\n1|2|3";
        //when
        String customDivisionMark = calculator.getCustomDivisionMark(stringWithDivisionMark);
        //then
        assertThat(customDivisionMark).isEqualTo("|");
    }

    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자가 없다면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void customDivisionMarkIsNull() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDivisionMark = "1,2:3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDivisionMark(stringWithDivisionMark))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면  WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void customDivisionMarkIsNull2() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDivisionMark = "//|\t1|2|3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDivisionMark(stringWithDivisionMark))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면  WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void customDivisionMarkIsNull3() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDivisionMark = "//|1|2|3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDivisionMark(stringWithDivisionMark))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }
}