package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void getCustomDelimiter() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDelimiter = "//|\n1|2|3";
        //when
        String customDelimiter = calculator.getCustomDelimiter(stringWithDelimiter);
        //then
        assertThat(customDelimiter).isEqualTo("|");
    }

    @DisplayName("문자열 앞부분이 \"//\"로 시작하지 않으면 customDelimiter은 null을 반환한다.")
    @Test
    void customDivisionMarkIsNul() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDelimiter = "1,2:3";
        //when
        String customDelimiter = calculator.getCustomDelimiter(stringWithDelimiter);
        //then
        assertThat(customDelimiter).isNull();
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDelimiter = "//|\t1|2|3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong2() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDelimiter = "//|1|2|3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분이 \"//\"로 시작하지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong3() {
        //given
        Calculator calculator = new Calculator();
        String stringWithDelimiter = "/|\n1|2|3";
        //when
        //then
        assertThatThrownBy(() -> calculator.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }
}