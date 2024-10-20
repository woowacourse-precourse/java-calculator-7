package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.Validator;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void 기본_구분자로_쉼표와콜론_혼합일때_입력에대해_6반환() {
        String input = "1,2:3";
        int result = Calculator.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빈_문자열_입력했을때_0반환() {
        String input = "";
        int result = Calculator.sum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본구분자로_숫자가아닌_입력을했을때_IllegalArgumentException_발생() {
        String input = "a,b,c";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> Validator.parseNumber(input));
        assertThat(thrown.getMessage()).isEqualTo("유효하지 않는 입력 형식입니다.");
    }

    @Test
    void 음수입력했을때_IllegalArgumentException_발생() {
        String input = "-1,2,3";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> Calculator.sum(input));
        assertThat(thrown.getMessage()).isEqualTo("음수는 유효하지 않는 입력 형식입니다.");
    }

}