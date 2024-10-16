package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    DelimiterService delimiterService;
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        delimiterService = new DelimiterService();
        calculatorService = new CalculatorService(delimiterService);
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
        String input = "//;\n1;2;3";

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
        int result = delimiterSplit(input);

        // then
        assertThat(result).isEqualTo(123);
    }

    private int delimiterSplit(String input) {
        if (isNotDefaultDelimiter(input) && isNotCustomDelimiter(input)) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private boolean isNotDefaultDelimiter(String input) {
        return !(input.contains(",") || input.contains(":"));
    }

    private boolean isNotCustomDelimiter(String input) {
        return !input.startsWith("//");
    }

}