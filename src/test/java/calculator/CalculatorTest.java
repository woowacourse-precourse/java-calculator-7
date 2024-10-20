package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //정상적으로 돌아가는 TEST
    @Test
    public void EmptyInput() {
        assertEquals(0, Calculator.stringSum(""));
    }

    @Test
    public void OnlyNumberInput() {
        assertEquals(123, Calculator.stringSum("123"));
    }

    @Test
    public void CommaDelimitersInput() {
        assertEquals(6, Calculator.stringSum("1,2,3"));
    }

    @Test
    public void ColonDelimitersInput() {
        assertEquals(6, Calculator.stringSum("1:2:3"));
    }

    @Test
    public void DefaultDelimitersInput() {
        assertEquals(15, Calculator.stringSum("5,5:5"));
    }

    //[주의] 콘솔과 달리 문자열에선 \n이 줄바꾸기로 인식하기에 \\n로 처리
    private static final String INPUT_MINUS_DELIMITERS = "//-\\n5-5-5";

    @Test
    public void MinusDelimitersInput() {
        assertEquals(15, Calculator.stringSum(INPUT_MINUS_DELIMITERS));
    }

    //예외처리 TEST
    @Test
    public void UndefinedDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("1|2,3");
        });
        assertEquals("사용할 수 없는 구분자가 포함되어 있습니다", exception.getMessage());
    }

    @Test
    public void ConsecutiveDelimiters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("1,,2:3");
        });
        assertEquals("연속된 구분자는 허용되지 않습니다.", exception.getMessage());
    }

    @Test
    public void StartsWithDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum(",1,2:3");
        });
        assertEquals("입력은 구분자로 시작할 수 없습니다.", exception.getMessage());
    }

    @Test
    public void MinusNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("1,-2,3");
        });
        assertEquals("유효하지 않은 입력값입니다.", exception.getMessage());
    }

    @Test
    public void InvalidCustomDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("//?\n1?2");
        });
        assertEquals("구분자 정의가 올바르지 않습니다.", exception.getMessage());
    }

    @Test
    public void NoCustomDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("//\n1?2");
        });
        assertEquals("구분자 정의가 올바르지 않습니다.", exception.getMessage());
    }

    @Test
    public void testMissingCustomDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.stringSum("//\\n1,2");
        });
        assertEquals("구분자 정의에 커스텀 구분자가 없습니다.", exception.getMessage());
    }
}