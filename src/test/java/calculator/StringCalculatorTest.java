package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("기본 구분자 테스트")
    void testBasicDelimiters() {
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("2")).isEqualTo(2);
        assertThat(StringCalculator.calculate("100,200:300")).isEqualTo(600);
    }

    @Test
    @DisplayName("공백이 포함된 입력 처리")
    void testDelimitersWithSpaces() {
        assertThat(StringCalculator.calculate(" 1,2:3 ")).isEqualTo(6);
        assertThatThrownBy(() -> StringCalculator.calculate(" 1, 2 :3 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단일 문자 커스텀 구분자 사용")
    void testSingleCustomDelimiter() {
        assertThat(StringCalculator.calculate("//;\\n1;2;3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("//+\\n1,2:3+4")).isEqualTo(10);
        assertThat(StringCalculator.calculate("//a\\n1,2:3a4")).isEqualTo(10);
        assertThat(StringCalculator.calculate("//|\\n1,2:3|4")).isEqualTo(10);
        assertThat(StringCalculator.calculate("//\\\\n1,2:3\\4")).isEqualTo(10);
        assertThat(StringCalculator.calculate("//1\\n21314")).isEqualTo(9);
    }

    @Test
    @DisplayName("이스케이프가 필요한 특수 문자 구분자 사용")
    void testSpecialCharacterDelimiter() {
        assertThat(StringCalculator.calculate("//*\\n1*2*3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("//.\\n1.2.3")).isEqualTo(6);
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 처리")
    void testInvalidCustomDelimiterFormats() {
        // 커스텀 구분자 누락
        assertThatThrownBy(() -> StringCalculator.calculate("//\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 커스텀 구분자 뒤에 \n 없음
        assertThatThrownBy(() -> StringCalculator.calculate("//;1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 여러 개의 커스텀 구분자 선언
        assertThatThrownBy(() -> StringCalculator.calculate("//;\\n//|\\n1;|2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 커스텀 구분자가 여러 글자
        assertThatThrownBy(() -> StringCalculator.calculate("//;;\\n1;;2;;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력이 구분자로 시작하거나 끝나는 경우")
    void testInputStartsOrEndsWithDelimiter() {
        // 시작
        assertThatThrownBy(() -> StringCalculator.calculate(",1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 끝
        assertThatThrownBy(() -> StringCalculator.calculate("1,2,3,"))
                .isInstanceOf(IllegalArgumentException.class);

        // 시작과 끝
        assertThatThrownBy(() -> StringCalculator.calculate(",1,2,3,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일 구분자가 연속으로 사용되는 경우")
    void testConsecutiveDelimiters() {
        // 기본 구분자
        assertThatThrownBy(() -> StringCalculator.calculate("1,,2:3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 커스텀 구분자
        assertThatThrownBy(() -> StringCalculator.calculate("//;\\n1;;2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        // 여러 구분자 혼용
        assertThatThrownBy(() -> StringCalculator.calculate("1,,2::3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열이 포함된 경우")
    void testNonNumericStrings() {
        assertThatThrownBy(() -> StringCalculator.calculate("1,2:three"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 구분자가 들어가 있는 경우")
    void testWrongDelimiter() {
        assertThatThrownBy(() -> StringCalculator.calculate("1,2+3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양수가 아닌 숫자가 포함된 경우")
    void testNegativeNumbers() {
        assertThatThrownBy(() -> StringCalculator.calculate("1,-2:3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> StringCalculator.calculate("1,0:3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 합계가 int 범위를 초과하는 경우")
    void testSumOverflow() {
        assertThatThrownBy(() -> StringCalculator.calculate("1000000000,2000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 입력 및 null 처리 테스트")
    void testEmptyAndNullInput() {
        // null 입력
        assertThatThrownBy(() -> StringCalculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);

        // 빈 문자열
        assertThatThrownBy(() -> StringCalculator.calculate(""))
                .isInstanceOf(IllegalArgumentException.class);

        // 공백만 있는 문자열
        assertThatThrownBy(() -> StringCalculator.calculate("    "))
                .isInstanceOf(IllegalArgumentException.class);

        // 구분자만 있는 문자열
        assertThatThrownBy(() -> StringCalculator.calculate(",:"))
                .isInstanceOf(IllegalArgumentException.class);

        // 커스텀 구분자와 함께 구분자만 있는 문자열
        assertThatThrownBy(() -> StringCalculator.calculate("//x\n , ,,x  ,:"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}