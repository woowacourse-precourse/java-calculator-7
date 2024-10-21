package calculator.service.parse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveBigIntegerCalculatorInputParseServiceTest {

    private final PositiveBigIntegerCalculatorInputParseService positiveBigIntegerCalculatorInputParseService;

    public PositiveBigIntegerCalculatorInputParseServiceTest() {
        this.positiveBigIntegerCalculatorInputParseService = new PositiveBigIntegerCalculatorInputParseService();
    }

    @Test
    @DisplayName("parseSumInput은 음수가 포함된 입력에 대해 IllegalArgumentException을 던진다.")
    public void parseSumInput_WithNegativeNumber_ThrowsIllegalArgumentException() {
        // given
        String input = "1,-2,3";

        // when & then
        Assertions.assertThatThrownBy(() ->
                positiveBigIntegerCalculatorInputParseService.parseSumInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
