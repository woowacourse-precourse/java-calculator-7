package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.command.SumCommand;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService();

    @BeforeEach
    void setUp() {
        calculator.setCommand(new SumCommand());
    }

    @Test
    void 빈_문자열_처리_테스트() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void 기본_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void 커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n1#2#3"));
    }

    @Test
    void 긴_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//qq\\n1qq2qq3"));
    }

    @Test
    void 기본_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n1#2:3"));
    }

    @Test
    void 여러개의_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n//$\\n1#2$3"));
    }

    @Test
    void 커스텀_구분자가_공백_문자열일_경우_처리_테스트() {
        assertEquals(15, calculator.calculate("// \\n12 3"));
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("////\\n1//2//3"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트2() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("//\\n\\n1\\n2\\n3"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트3() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("//\\n\\n////\\n1//2\\n3"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트4() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("//\\n\\n//$\\n////\\n1//2\\n3$4,5"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트5() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("////\\n\\n//$\\n////\\n1//2\\n3$4,5//\\n6"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_포맷이_구분자일_경우_예외_테스트6() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("//////\\n\\n\\n1////\\n\\n2"));
        assertEquals("올바르지 않은 형식입니다. '//'나 '\\n'은 커스텀 구분자로 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 음수_입력_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,-2,3"));
        assertEquals("음수 입력은 불가능합니다.", exception.getMessage());
    }

    @Test
    void 숫자_커스텀_구분자_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//1\\n213"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 숫자 형식이 불가능합니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자가_빈_문자열일_경우_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//\\n123"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 빈 문자열이 불가합니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_실수_예외_처리_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;1;2;3"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_실수_예외_처리_테스트2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//;\n//#1;2;3"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_실수_예외_처리_테스트3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(";\\n1;2;3"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_위치_예외_처리_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("//;\\n1;2;//$\\n4$4"));
        assertEquals("올바르지 않은 형식입니다. 커스텀 구분자는 문자열 맨 앞에 정의해야 합니다.", exception.getMessage());
    }

    @Test
    void 숫자가_아닌_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,a,3"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }
}