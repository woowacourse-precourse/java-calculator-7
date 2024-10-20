package calculator;

import calculator.model.Delimiter;
import calculator.model.StringCalculation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculationTest {
    @Test
    @DisplayName("구분자를 기준으로 문자열을 분리한다")
    void 문자열_분리_구분자기준() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithDelimiter("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 분리 테스트")
    void 커스텀_구분자_기준_분리() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithCustomDelimiter("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("덧셈 기능 구현")
    void 덧셈_기능_테스트() {
        StringCalculation stringCalculation = new StringCalculation();

        Assertions.assertThat(stringCalculation.calculate(new String[]{"1", "2", "3"})).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈 시 음수가 있으면 예외처리")
    void 덧셈_음수_예외처리_발생() {
        StringCalculation stringCalculation = new StringCalculation();

        Assertions.assertThatThrownBy(
                        () -> stringCalculation.calculate(new String[]{"-1", "2", "3"})
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 덧셈 대상이 아님");
    }

    @Test
    @DisplayName("빈문자열 분리 테스트")
    void 빈문자열_분리_테스트() {
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(delimiter.splitWithCustomDelimiter("")).containsExactly("");
    }

    @Test
    @DisplayName("빈문자열 입력 시 결과가 0")
    void 빈문자열의_연산결과는_0() {
        StringCalculation stringCalculation = new StringCalculation();
        Delimiter delimiter = new Delimiter();

        Assertions.assertThat(stringCalculation.calculate(
                delimiter.splitWithCustomDelimiter(""))).isEqualTo(0);
    }

}
