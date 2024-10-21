package calculator.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CalculationFormulaTest {

    private static final String CUSTOM_SEPARATOR_HEADER = "//";
    private static final String CUSTOM_SEPARATOR_FOOTER = "\\n";

    @Test
    void 공백문자열만_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from("");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 양의정수가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from("1234");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("1234");
    }

    @Test
    void 양의소수가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from("4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("4.5");
    }

    @Test
    void 기본구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(",:");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        assertThat(CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + ";"))
                .isInstanceOf(CalculationFormula.class);
    }

    @Test
    void 온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + ".");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "2" + CUSTOM_SEPARATOR_FOOTER + "2");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 양의정수와_양의소수와_기본구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from("1,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(BigDecimal.ONE.add(new BigDecimal("4.5")).toString());
    }

    @Test
    void 양의정수와_양의소수와_커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + "1,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(BigDecimal.ONE.add(new BigDecimal("4.5")).toString());
    }

    @Test
    void 양의정수와_양의소수와_온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "1,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                BigDecimal.ONE.add(new BigDecimal("4")).add(new BigDecimal("5")).toString());
    }

    @Test
    void 양의정수와_양의소수와_숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "3" + CUSTOM_SEPARATOR_FOOTER + "1,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                BigDecimal.ONE.add(new BigDecimal("4.5")).toString());
    }

    @Test
    void 양의정수와_양의소수와_기본구분자와_커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + "1;3,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                BigDecimal.ONE.add(new BigDecimal("3")).add(new BigDecimal("4.5")).toString());
    }

    @Test
    void 양의정수와_양의소수와_기본구분자와_온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "1:3,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                BigDecimal.ONE
                        .add(new BigDecimal("3"))
                        .add(new BigDecimal("4"))
                        .add(new BigDecimal("5"))
                        .toString());
    }

    @Test
    void 양의정수와_양의소수와_기본구분자와_숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "1" + CUSTOM_SEPARATOR_FOOTER + "1:3,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(new BigDecimal("3").add(new BigDecimal("4.5")).toString());
    }

    @Test
    void 양의소수와_기본구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(",4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("4.5");
    }

    @Test
    void 양의소수와_커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + "4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("4.5");
    }

    @Test
    void 양의소수와_온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(new BigDecimal("4").add(new BigDecimal("5")).toString());
    }

    @Test
    void 양의소수와_숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "1" + CUSTOM_SEPARATOR_FOOTER + "4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("4.5");
    }

    @Test
    void 양의소수와_기본구분자와_커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + "1.5;,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                new BigDecimal("1.5").add(new BigDecimal("4.5")).toBigInteger().toString());
    }

    @Test
    void 양의소수와_기본구분자와_온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + "1.5:,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo(
                BigDecimal.ONE
                        .add(new BigDecimal(5))
                        .add(new BigDecimal("4"))
                        .add(new BigDecimal("5"))
                        .toString());
    }

    @Test
    void 양의소수와_기본구분자와_숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "1" + CUSTOM_SEPARATOR_FOOTER + "1:,4.5");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("4.5");
    }

    @Test
    void 기본구분자와_커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + ";" + CUSTOM_SEPARATOR_FOOTER + ",");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 기본구분자와_온점커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "." + CUSTOM_SEPARATOR_FOOTER + ",");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 기본구분자와_숫자커스텀구분자가_입력된_계산식을_성공적으로_생성하고_합산가능하다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "1" + CUSTOM_SEPARATOR_FOOTER + ",");
        assertThat(actual).isInstanceOf(CalculationFormula.class);
        assertThat(actual.calculate()).isEqualTo("0");
    }

    @Test
    void 소수덧셈으로_소수점이하가_0이면_덧셈의_정수부만_반환한다() {
        CalculationFormula actual = CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "#" + CUSTOM_SEPARATOR_FOOTER + "1,2:3.4,5.6");
        assertThat(actual.calculate())
                .isEqualTo(BigDecimal.valueOf(1 + 2 + 3.4D + 5.6D).toBigInteger().toString());
    }

    @Test
    void 생성시_널파라미터를_넘기면_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from(null))
                .isInstanceOf(IllegalArgumentException.class);
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
        assertThatThrownBy(() -> CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + CUSTOM_SEPARATOR_FOOTER + "1234")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자래퍼를_커스텀구분자로_입력하면_예외발생() {
        assertThatThrownBy(() ->
                CalculationFormula.from(CUSTOM_SEPARATOR_HEADER + "////" + CUSTOM_SEPARATOR_FOOTER + "1,23")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER
                        + CUSTOM_SEPARATOR_FOOTER
                        + CUSTOM_SEPARATOR_FOOTER
                        + "1,23")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수부가_없는_양의실수가_입력된_계산식은_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from(".5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 소수부가_없는_양의실수가_입력된_계산식은_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from("1."))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 양의소수와_정수부에_해당하는_숫자커스텀구분자가_입력된_계산식은_정수부유실로_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "1" + CUSTOM_SEPARATOR_FOOTER + "1.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 양의소수와_소수부에_해당하는_숫자커스텀구분자가_입력된_계산식을_소수부유실로_예외발생() {
        assertThatThrownBy(() -> CalculationFormula.from(
                CUSTOM_SEPARATOR_HEADER + "5" + CUSTOM_SEPARATOR_FOOTER + "1.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}