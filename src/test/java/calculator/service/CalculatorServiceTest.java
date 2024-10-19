package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService service = new CalculatorService();

    @Test
    public void 커스텀_구분자_지정_형식_예외_테스트() {
        // given
        String input = "//;1;2;3";

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자의 지정 형식이 잘못되었습니다.");
    }

    @Test
    public void 커스텀_구분자_위치_예외_테스트() {
        // given
        String input = "1,2,3//;\n4,5";

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 입력 시작 위치에서만 지정할 수 있습니다.");
    }

    @Test
    public void 커스텀_구분자_여러번_지정_예외_테스트() {
        // given
        String input = "//;\\n1;2//s\\n3";

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 번만 지정할 수 있습니다.");
    }

    @Test
    public void 커스텀_구분자_문자열_예외_테스트() {
        // given
        String input = "//**\\n1**2**3";

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 공백, 문자열이 아닌 하나의 문자여야 합니다.");
    }

    @Test
    public void 커스텀_구분자_공백_예외_테스트() {
        // given
        String input = "//\\n1:2:3";

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 공백, 문자열이 아닌 하나의 문자여야 합니다.");
    }

    @Test
    public void 커스텀_구분자_숫자_예외_테스트() {
        // given
        String input = "//1\\n1,2,3";  // 숫자로 된 커스텀 구분자

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 숫자가 될 수 없습니다.");
    }

    @Test
    public void 커스텀_구분자_점_예외_테스트() {
        // given
        String input = "//.\\n1.2.3";  // '.'로 된 커스텀 구분자

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 '.', '-' 이 될 수 없습니다.");
    }

    @Test
    public void 커스텀_구분자_대시_예외_테스트() {
        // given
        String input = "//-\\n1-2-3";  // '-'로 된 커스텀 구분자

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 '.', '-' 이 될 수 없습니다.");
    }

    @Test
    public void 올바르지_않은_구분자_예외_테스트() {
        // given
        String input = "1;2:3";  // ';'는 유효한 구분자가 아님

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 구분자 혹은 입력값이 있습니다.");
    }

    @Test
    public void 파싱_불가_입력_값_예외_테스트() {
        // given
        String input = "1,abc,3";  // 'abc'는 파싱할 수 없는 값

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 구분자 혹은 입력값이 있습니다.");
    }

    @Test
    public void 음수_입력_예외_테스트() {
        // given
        String input = "1,-2,0";  // 음수와 0이 포함된 입력 값

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수를 입력해주세요.");
    }

    @Test
    public void 숫자_0_입력_예외_테스트() {
        // given
        String input = "1,2,0";  // 음수와 0이 포함된 입력 값

        // when & then
        Assertions.assertThatThrownBy(() -> service.parseInputAndCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수를 입력해주세요.");
    }
}
