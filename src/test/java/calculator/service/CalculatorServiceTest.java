package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.DelimiterExtractor;
import calculator.service.command.SumCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService(new DelimiterExtractor());

    @BeforeEach
    void setUp() {
        calculator.setCommand(new SumCommand());
    }

    @Test
    void 빈_문자열_처리() {
        assertEquals("0", calculator.calculate(""));
    }

    @Test
    void 기본_구분자_처리() {
        assertEquals("6", calculator.calculate("1,2:3"));
    }

    @Test
    void 커스텀_구분자가_하이픈일_경우() {
        assertEquals("6", calculator.calculate("//-\\n1-2-3"));
    }

    @Test
    void 커스텀_구분자_처리() {
        assertEquals("6", calculator.calculate("//#\\n1#2#3"));
    }

    @Test
    void 기본_커스텀_구분자_처리() {
        assertEquals("6", calculator.calculate("//#\\n1#2:3"));
    }

    @Test
    void 여러개의_커스텀_구분자_처리() {
        assertEquals("6", calculator.calculate("//#\\n//$\\n1#2$3"));
    }

    @Test
    void 커스텀_구분자가_공백_문자열일_경우_처리() {
        assertEquals("15", calculator.calculate("// \\n12 3"));
    }

    @Test
    void 커스텀_구분자가_기본_구분자일_경우() {
        assertEquals("12", calculator.calculate("//,\\n1,2,4:5"));
    }

    @ParameterizedTest
    @CsvSource({"//;1;2;3", "//;\n//#1;2;3", ";\\n1;2;3", "//-\\n,4-3-4,-4"})
    void 커스텀_구분자_실수_예외_처리(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 연속된_구분자_예외_처리() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(",,,,,,3"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }
}