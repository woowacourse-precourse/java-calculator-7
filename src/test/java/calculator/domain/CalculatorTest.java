package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorTest {

    InputText inputText = new InputText("//!?!\\n12,34:56!?!78:910");
    Calculator calculator = new Calculator();

    @Test
    void 메인로직_테스트() {
        int result = calculator.calculatorLogic(inputText);
        assertThat(result).isEqualTo(1090);
    }

    @Test
    void 숫자배열_테스트() {
        String[] numberArray = calculator.makeNumberArray(inputText);
        assertThat(numberArray).containsOnly("12","34","56","78","910");
    }

    @Test
    void 커스텀구분자_선분리() {
        String result = calculator.customSeparatorLogic(inputText.getText(), inputText.getSeparatorList());
        assertThat(result).isEqualTo("12,34:56,78:910");
    }

    @Test
    void 조건_테스트() {
        calculator.checkCondition("1");
        calculator.checkCondition("");

        assertThatThrownBy(() -> calculator.checkCondition("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> calculator.checkCondition("-10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> calculator.checkCondition("hello"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> calculator.checkCondition("//"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈칸_테스트() {
        int number = calculator.checkBlank("5");
        int blank = calculator.checkBlank("");

        assertThat(number).isEqualTo(5);
        assertThat(blank).isEqualTo(0);

    }
}