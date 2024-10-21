package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void 빈문자열이_입력되면_0을_반환한다() {
        // given
        String input = "";

        // when
        int result = StringAddCalculator.add(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void null이_입력되면_예외가_발생한다() {
        // given
        String input = null;

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 null입니다.");
    }

    @Test
    void 기본_구분자_사용시_계산_대상_문자열이_9자를_넘으면_예외가_발생한다() {
        // given
        String input = "1,2,3,4,5,6";

        // when, then
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("계산 대상 문자열의 길이가 9자를 초과했습니다.");
    }

    @Test
    void 커스텀_구분자_사용시_계산_대상_문자열이_9자를_넘으면_예외가_발생한다() {
        // given
        String input = "//;\n1;2;3;4;5;6;7";

        // when, then: 예외 발생 여부 확인
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("계산 대상 문자열의 길이가 9자를 초과했습니다.");
    }

    @Test
    void 음수_입력시_예외가_발생한다() {
        // given
        String input = "1,-2,3,-5";

        // when, then: 예외 발생 여부 확인 및 모든 음수 값 포함 여부 확인
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다: -2, -5");
    }

    @Test
    void 소수_입력시_예외가_발생한다() {
        // given
        String input = "1,2.5,3";

        // when, then
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("소수는 허용되지 않습니다: 2.5");
    }
}
