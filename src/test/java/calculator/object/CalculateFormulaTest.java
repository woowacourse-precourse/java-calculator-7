package calculator.object;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateFormulaTest {

    @Test
    void 숫자만_입력된_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("1234");
        assertThat(actual.customSeparator()).isEqualTo("");
        assertThat(actual.numbers()).isEqualTo(List.of(BigDecimal.valueOf(1234L)));
    }

    @Test
    void 문자만_입력된_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("//g\n,:g");
        assertThat(actual.customSeparator()).isEqualTo("g");
        // 아래의 검증은, 계산 결과 기능을 구현하면, 계산 결과를 비교하도록 리팩토링 하자
        assertThat(actual.numbers()).isEqualTo(List.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    @Test
    void 양의정수와_문자가_입력된_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("//?\n1,23,456:7890");
        assertThat(actual.customSeparator()).isEqualTo("?");
        // 아래의 검증은, 계산 결과 기능을 구현하면, 계산 결과를 비교하도록 리팩토링 하자
        assertThat(actual.numbers()).isEqualTo(List.of(
                BigDecimal.valueOf(1L),
                BigDecimal.valueOf(23L),
                BigDecimal.valueOf(456L),
                BigDecimal.valueOf(7890L)
        ));
    }

    @Test
    void 소수와_문자가_입력된_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("//?\n1,2.3");
        assertThat(actual.customSeparator()).isEqualTo("?");
        // 아래의 검증은, 계산 결과 기능을 구현하면, 계산 결과를 비교하도록 리팩토링 하자
        assertThat(actual.numbers()).isEqualTo(List.of(
                BigDecimal.valueOf(1L),
                new BigDecimal("2.3")
        ));
    }

    @Test
    void 기본구분자를_커스텀구분자로_입력해도_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("//,\n1,2.3");
        assertThat(actual.customSeparator()).isEqualTo(",");
        // 아래의 검증은, 계산 결과 기능을 구현하면, 계산 결과를 비교하도록 리팩토링 하자
        assertThat(actual.numbers()).isEqualTo(List.of(
                BigDecimal.valueOf(1L),
                new BigDecimal("2.3")
        ));
    }

    @Test
    void 소수점을_커스텀구분자로_입력하면_소수도_분리된_계산식을_성공적으로_생성() {
        CalculateFormula actual = CalculateFormula.from("//.\n1,2.3");
        assertThat(actual.customSeparator()).isEqualTo(".");
        // 아래의 검증은, 계산 결과 기능을 구현하면, 계산 결과를 비교하도록 리팩토링 하자
        assertThat(actual.numbers()).isEqualTo(List.of(
                BigDecimal.valueOf(1L),
                BigDecimal.valueOf(2L),
                BigDecimal.valueOf(3L)
        ));
    }

    @Test
    void 음수를_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculateFormula.from("-1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CalculateFormula.from("//.\n-1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이스케이프문자를_커스텀구분자로_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculateFormula.from("//\\n1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여러개의_커스텀구분자를_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculateFormula.from("//ABC\n1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자_기호를_입력하고_커스텀문자를_넣지않아도_예외발생() {
        assertThatThrownBy(() -> CalculateFormula.from("//\n1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자래퍼를_커스텀구분자로_입력하면_예외발생() {
        assertThatThrownBy(() -> CalculateFormula.from("////\n1,23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CalculateFormula.from("//\n\n1,23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}