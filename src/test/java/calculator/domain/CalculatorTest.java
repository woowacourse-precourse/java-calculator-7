package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 기본_문자열_분리_테스트() {
        Calculator calculator = new Calculator();
        assertThat(calculator.split("1,2:3")).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 커스텀_문자열_분리_테스트() {
        Calculator calculator = new Calculator("");
        assertThat(calculator.split("//;\\n1;2;3;")).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 문자열_파싱_성공_테스트() {
        Calculator calculator = new Calculator();
        assertThat(calculator.parse("1")).isEqualTo(1);
    }

    @Test
    void 문자열_파싱_문자_입력_실패_테스트() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.parse("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("잘못된 값을 입력했습니다.");
    }

    @Test
    void 문자열_파싱_음수_입력_실패_테스트() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.parse("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("잘못된 값을 입력했습니다.");
    }

    @Test
    void 덧셈_테스트() {
        Calculator calculator = new Calculator("1,2,3");
        assertThat(calculator.sum()).isEqualTo(6);
    }
}
