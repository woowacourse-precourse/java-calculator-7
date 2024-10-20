package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    void testBasicDelimiter() {
        assertEquals(6, Application.calculator("1,2,3")); // 쉼표 구분자
        assertEquals(6, Application.calculator("1:2:3")); // 콜론 구분자
        assertEquals(10, Application.calculator("1,2:3:4")); // 콜론과 쉼표 혼합
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(6, Application.calculator("//;\n1;2;3")); // 세미콜론 구분자
        assertEquals(10, Application.calculator("//-\n1-2-3-4")); // 하이픈 구분자
        assertEquals(15, Application.calculator("//|\n3|5|7")); // 파이프 구분자
    }

    @Test
    void testInputWithSpaces() {
        assertEquals(6, Application.calculator("1, 2 , 3")); // 쉼표 구분자, 공백 포함
        assertEquals(10, Application.calculator("//;\n 1 ; 2 ; 3 ;4 ")); // 세미콜론 구분자, 공백 포함
    }

    @Test
    void testEmptyOrNullInput() {
        assertEquals(0, Application.calculator(null)); // null 입력
        assertEquals(0, Application.calculator("")); // 빈 문자열 입력
        assertEquals(0, Application.calculator("    ")); // 공백만 있는 문자열 입력
        assertEquals(0, Application.calculator(",:,:")); // 구분자만 있을 때
    }

    @Test
    void testSingleNumberInput() {
        assertEquals(1, Application.calculator("1")); // 숫자 하나만 있을 때
        assertEquals(5, Application.calculator("5")); // 다른 숫자 하나만 있을 때
    }

    @Test
    void testNegativeNumberInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Application.calculator("1,-2,3")); // 음수 포함
        assertEquals("음수는 입력할 수 없습니다: -2", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> Application.calculator("//;\n1;-2;3")); // 커스텀 구분자와 음수 포함
        assertEquals("음수는 입력할 수 없습니다: -2", exception.getMessage());
    }

    @Test
    void testInvalidNumberInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Application.calculator("1,a,3")); // 유효하지 않은 숫자 포함
        assertEquals("유효하지 않은 숫자가 입력되었습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> Application.calculator("//;\n1;X;3")); // 커스텀 구분자와 유효하지 않은 숫자 포함
        assertEquals("유효하지 않은 숫자가 입력되었습니다.", exception.getMessage());
    }
}
