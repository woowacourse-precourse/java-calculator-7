package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void 기본_구분자로_빈_문자열을_입력했을때_0을_반환() {
        String input = "";
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본_구분자로_숫자를_입력했을때_합을_반환() {
        String input = "1,2";
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 기본_구분자로_여러_숫자를_입력했을때_합을_반환() {
        String input = "1,2,3";
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 기본_구분자로_쉼표와_콜론을_혼합하여_입력했을때_합을_반환() {
        String input = "1,2:3";
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자를_사용했을때_합을_반환() {
        String input = "//;\\n1;2;3";
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 잘못된_숫자형식을_입력했을때_IllegalArgumentException을_발생() {
        String input = "1,2,a";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.sum(input);
        });
        assertThat(thrown.getMessage()).isEqualTo("유효하지 않는 숫자 형식입니다.");
    }

    @Test
    void 음수를_입력했을때_IllegalArgumentException을_발생() {
        String input = "1,-2,3";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.sum(input);
        });
        assertThat(thrown.getMessage()).isEqualTo("음수는 입력할 수 없습니다.");
    }
}
