package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest {

    @Test
    @DisplayName("빈 입력값에 대한 테스트: 결과는 0이어야 함")
    public void testEmptyInput() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    @DisplayName("기본 입력값에 대한 테스트: 쉼표로 구분된 숫자들의 합을 확인")
    public void testBasicInput() {
        assertEquals(3, Calculator.add("1,2")); // 1 + 2 = 3
        assertEquals(6, Calculator.add("1,2,3")); // 1 + 2 + 3 = 6
        assertEquals(6, Calculator.add("1,2:3")); // 1 + 2 + 3 = 6 (쉼표와 콜론 혼합)
    }

    @Test
    @DisplayName("커스텀 구분자에 대한 테스트: //와 \\n을 사용하여 구분된 입력값의 합을 확인")
    public void testCustomDelimiter() {
        assertEquals(6, Calculator.add("//;\n1;2;3")); // 1 + 2 + 3 = 6
        assertEquals(10, Calculator.add("//#\n4#5#1")); // 4 + 5 + 1 = 10
    }

    @Test
    @DisplayName("잘못된 입력값에 대한 테스트: 예외가 발생하는지 확인")
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,2,3,a")); // 'a'는 잘못된 숫자
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,2:-3")); // -3은 음수
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("//;\n1;2;3;a")); // 'a'는 잘못된 숫자
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("//;\n1;2;3,4")); // 3과 4는 잘못된 구분자 사용
    }

    @Test
    @DisplayName("음수에 대한 테스트: 음수가 입력될 경우 예외가 발생하는지 확인")
    public void testNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,-2,3")); // -2는 음수
    }
}
