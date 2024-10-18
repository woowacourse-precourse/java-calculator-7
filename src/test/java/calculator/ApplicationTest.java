package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 빈문자열_테스트() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void 단일숫자_테스트() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void 두개의숫자_테스트() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void 여러개의숫자_테스트() {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    void 새줄구분자_사용시_예외발생_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1\n2,3"));
    }

    @Test
    void 사용자정의구분자_테스트() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void 음수_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2"));
    }

    @Test
    void 유효하지않은숫자_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1,a"));
    }

    @Test
    void 유효하지않은사용자정의구분자_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("//\n1;2"));
    }

    @Test
    void 사용자정의구분자_덧셈결과_테스트() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void 사용자정의구분자_여러숫자_테스트() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void 사용자정의구분자_여러문자_테스트() {
        assertEquals(6, calculator.add("//;;\n1;;2;;3"));
    }

    @Test
    void 사용자정의구분자_특수문자_테스트() {
        assertEquals(6, calculator.add("//***\n1***2***3"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[0]);
    }
}