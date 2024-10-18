package calculator.service;

import calculator.validation.DelimiterNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {

    DelimiterService delimiterService;
    DelimiterNumberValidator delimiterNumberValidator;
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        delimiterService = new DelimiterService();
        delimiterNumberValidator = new DelimiterNumberValidator();
        calculatorService = new CalculatorService(delimiterService, delimiterNumberValidator);
    }

    @Test
    @DisplayName("기본 구분자(콤마와 콜론)를 기준으로 숫자를 추출하여 합을 구한다.")
    void 기본_구분자로_숫자를_추출하여_합을_구한다() {
        // given
        String input = "1,2:3";

        // when
        int result = calculatorService.calculateSum(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 숫자를 추출하여 합을 구한다.")
    public void 커스텀_구분자로_숫자를_추출하여_합을_구한다() {
        // given
        String input = "//;\\n1;2;3";

        // when
        int result = calculatorService.calculateSum(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자가 입력되지 않고, 양수만 입력했을 때 숫자를 그대로 반환한다.")
    void 구분자가_없고_양수만_있는_경우_양수만_반환한다() {
        // given
        String input = "123";

        // when
        int result = calculatorService.calculateSum(input);

        // then
        assertThat(result).isEqualTo(123);
    }
    
    @Test
    @DisplayName("구분자가 입력되지 않고, 문자만 입력되었을 때 예외가 발생한다.")
    void 구분자가_없고_문자만_입력된_경우_예외_발생() {
        // given
        String input = "a";

        // when, then
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자와 숫자를 정확하게 입력해주세요.");
    }

    @Test
    @DisplayName("음수가 입력된 경우 예외가 발생한다.")
    void 음수가_입력된_경우_예외_발생() {
        // given
        String input = "1,2:-3";

        // when, then
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("구분자가 잘못된 위치에 있는 경우 예외가 발생한다.")
    void 구분자가_잘못된_위치에_있는_경우_예외_발생() {
        // given
        String input = "1,,2:3";

        // when, then
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자와 숫자를 정확하게 입력해주세요.");
    }

}