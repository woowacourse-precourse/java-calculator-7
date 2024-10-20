package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("[성공] 빈 값 입력 덧셈")
    void calculateWithNoneInput() {
        Calculator calculator = new Calculator("");
        assertThat(calculator.calculate()).isEqualTo(0);
    }

    @Test
    @DisplayName("[성공] 기본 구분자 덧셈")
    void calculateWithDefaultSplitter() {
        Calculator calculator = new Calculator("1,2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    @DisplayName("[성공] 기본 구분자 혼용 덧셈")
    void calculateWithMixedDefaultSplitter() {
        Calculator calculator = new Calculator("1,2:3");
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    @DisplayName("[성공] 사용자 정의 구분자 덧셈")
    void calculateWithCustomSplitter() {
        Calculator calculator = new Calculator("//;\n1;2;3");
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    @DisplayName("[성공] '/' 구분자 덧셈")
    void calculateWithSlash() {
        Calculator calculator = new Calculator("///\n1/2/3");
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    @DisplayName("[실패] 사용자 정의 복수 구분자 덧셈")
    void calculateWithMultipleCustomSplitter() {
        Calculator calculator = new Calculator("///;\n1/2;3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 형식입니다.");
    }

    @Test
    @DisplayName("[실패] 숫자 파싱 에러")
    void cannotParseLong() {
        Calculator calculator = new Calculator("1::2:3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 형식입니다.");
    }

    @Test
    @DisplayName("[실패] '\\n' 구분자 덧셈")
    void calculateWithEscapeNSplitter() {
        Calculator calculator = new Calculator("//\n\n1\n2\n3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 형식입니다.");
    }

}