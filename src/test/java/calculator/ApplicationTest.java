package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용_정수() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 기본_구분자_사용_실수() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.splitAndSum("1.2,2:3")).isEqualTo(6.2);
    }

    @Test
    void 커스텀_구분자_사용() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 예외_테스트_커스텀_구분자_누락() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThatThrownBy(() -> calculator.splitAndSum("//\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자를 찾을 수 없습니다.");
    }

    @Test
    void 예외_테스트_커스텀_구분자_기본_구분자_혼합() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThatThrownBy(() -> calculator.splitAndSum("//\n1.2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_숫자가_아닌_값_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThatThrownBy(() -> calculator.splitAndSum("가,2:3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식의 입력값입니다: 가");
    }

    @Test
    void 예외_테스트_빈_문자열_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThatThrownBy(() -> calculator.splitAndSum(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열이 입력되지 않았습니다.");
    }

    @Test
    void 예외_테스트_공백_문자열_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThatThrownBy(() -> calculator.splitAndSum(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열이 입력되지 않았습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
