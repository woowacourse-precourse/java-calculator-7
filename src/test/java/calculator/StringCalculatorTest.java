package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator(new Parser(), new InputValidator());

    // 1. 정상 입력 테스트 (쉼표와 콜론 구분자 사용)
    @Test
    void 기본_구분자_쉼표와_콜론_테스트() {
        String input = "1,2:3";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(6);  // 1 + 2 + 3 = 6
    }

    // 2. 빈 문자열 테스트
    @Test
    void 빈_문자열_테스트() {
        String input = "";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(0);  // 빈 문자열은 0 반환
    }

    // 3. 커스텀 구분자 테스트
    @Test
    void 커스텀_구분자_테스트() {
        String input = "//;\\n1;2;3";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(6);  // 1 + 2 + 3 = 6
    }

    // 4. 여러 개의 커스텀 구분자 테스트
    @Test
    void 여러_커스텀_구분자_테스트() {
        String input = "//;!#\\n1;2!3#4";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(10);  // 1 + 2 + 3 + 4 = 10
    }

    // 5. 음수 입력 예외 테스트
    @Test
    void 음수_숫자_입력_예외_테스트() {
        String input = "1,-2,3";
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative numbers are not allowed.");
    }

    // 6. 잘못된 숫자 형식 예외 테스트
    @Test
    void 잘못된_숫자_형식_입력_예외_테스트() {
        String input = "1,a,3";
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid number format.");
    }

    // 7. 잘못된 구분자 형식 예외 테스트
    @Test
    void 잘못된_구분자_형식_예외_테스트() {
        String input = "//;1;2;3";
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
