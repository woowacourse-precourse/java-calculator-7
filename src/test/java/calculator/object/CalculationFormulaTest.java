package calculator.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CalculationFormulaTest {

    private static final String CUSTOM_SEPARATOR_HEADER = "//";
    private static final String CUSTOM_SEPARATOR_FOOTER = "\\n";

    @Test
    void 숫자만_입력된_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula.from("1234");

//        assertThat(actual.separators().isCustomSeparatorEmpty()).isTrue();
        assertThat(actual.calculate())
                .isEqualTo("1234");
    }

    @Test
    void 문자만_입력된_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "g" + CUSTOM_SEPARATOR_FOOTER + ",:g");

//        assertThat(actual.separators().contains('g')).isTrue();
        assertThat(actual.calculate())
                .isEqualTo("0");
    }

    @Test
    void 양의정수와_문자가_입력된_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "?" + CUSTOM_SEPARATOR_FOOTER + "1,23,456:7890");

//        assertThat(actual.separators().contains('?')).isTrue();
        assertThat(actual.calculate())
                .isEqualTo(BigDecimal.valueOf(1L + 23L + 456L + 7890L).toString());
    }

    @Test
    void 소수와_문자가_입력된_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "?" + CUSTOM_SEPARATOR_FOOTER + "1,2.3");

//        assertThat(actual.separators().contains('?')).isTrue();
        assertThat(actual.calculate()).isEqualTo(BigDecimal.valueOf(1L)
                .add(new BigDecimal("2.3"))
                .toString());
    }

    @Test
    void 기본구분자를_커스텀구분자로_입력해도_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "," + CUSTOM_SEPARATOR_FOOTER + "1,2.3");

//        assertThat(actual.separators().contains(',')).isTrue();
        assertThat(actual.calculate()).isEqualTo(BigDecimal.valueOf(1L)
                .add(new BigDecimal("2.3"))
                .toString());
    }

    @Test
    void 소수점을_커스텀구분자로_입력하면_소수도_분리된_계산식을_성공적으로_생성() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "1,2.3");

//        assertThat(actual.separators().contains('.')).isTrue();
        assertThat(actual.calculate())
                .isEqualTo(BigDecimal.valueOf(1L)
                        .add(BigDecimal.valueOf(2L))
                        .add(BigDecimal.valueOf(3L))
                        .toString());
    }

    @Test
    void 음수를_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from("-1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "-1234")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자0을_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CalculationFormula.from("0.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이스케이프문자를_커스텀구분자로_입력시도하면_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + "\\n1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여러개의_커스텀구분자를_입력시도하면_예외발생() {
        assertThatThrownBy(() ->
                CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + "ABC" + CUSTOM_SEPARATOR_FOOTER + "1234")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자_기호를_입력하고_커스텀문자를_넣지않아도_예외발생() {
        assertThatThrownBy(() ->
                CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + CUSTOM_SEPARATOR_FOOTER + "1234")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자래퍼를_커스텀구분자로_입력하면_예외발생() {
        assertThatThrownBy(() ->
                CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + "////" + CUSTOM_SEPARATOR_FOOTER + "1,23")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                CalculationFormula.from(
                        CUSTOM_SEPARATOR_HEADER +
                                CUSTOM_SEPARATOR_FOOTER +
                                CUSTOM_SEPARATOR_FOOTER +
                                "1,23")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 양의정수로_모두더하기_연산을_시도하면_덧셈결과를_반환한다() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "1,2:3.4");

        assertThat(actual.calculate())
                .isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @Test
    void 양의소수를더해도_모두더하기_연산을_시도하면_덧셈결과를_반환한다() {
        CalculationFormula actual = CalculationFormula
                .from(CUSTOM_SEPARATOR_HEADER + "#" + CUSTOM_SEPARATOR_FOOTER + "1,2:3.4");

        assertThat(actual.calculate())
                .isEqualTo(String.valueOf(1 + 2 + 3.4D));
    }

    @Test
    void 소수덧셈으로_소수점이하가_0이면_덧셈의_정수부만_반환한다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "#" + CUSTOM_SEPARATOR_FOOTER + "1,2:3.4,5.6");
        assertThat(actual.calculate())
                .isEqualTo(BigDecimal.valueOf(1 + 2 + 3.4D + 5.6D).toBigInteger().toString());
    }

}