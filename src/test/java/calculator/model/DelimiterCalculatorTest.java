package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DelimiterCalculatorTest {

    private DelimiterCalculator delimiterCalculator;

    @BeforeEach
    public void setUp() {
        delimiterCalculator = new DelimiterCalculator();
    }

    @Test
    void 기본_구분자_유효한_입력() {
        //given
        String input = "1,2:3";

        //when
        int result = delimiterCalculator.calculate(input);

        //then
        assertEquals(6, result);
    }

    @Test
    void 커스텀_구분자_유효한_입력() {
        //given
        String input = "//;\\n1;2;3";

        //when
        int result = delimiterCalculator.calculate(input);

        //then
        assertEquals(6, result);
    }

    @Test
    void 입력_공백_포함() {
        //given
        String input = "  1, 2   : 3";

        //when
        int result = delimiterCalculator.calculate(input);

        //then
        assertEquals(6, result);
    }

    @Test
    void 커스텀_구분자_여러_개_사용() {
        //given
        String input = "//;*\\n1;2*3";

        //when
        int result = delimiterCalculator.calculate(input);

        //then
        assertEquals(6, result);
    }

    @Test
    void 입력_빈_값() {
        //given
        String input = "";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.NULL_OR_EMPTY_INPUT, exception.getMessage());
    }

    @Test
    void 입력_공백_한_칸() {
        //given
        String input = " ";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.INVALID_INPUT, exception.getMessage());
    }

    @Test
    void 입력_널() {
        //given
        String input = null;

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.NULL_OR_EMPTY_INPUT, exception.getMessage());
    }

    @Test
    void 기본_구분자_음수() {
        //given
        String input = "1,-2,3";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.INVALID_INPUT, exception.getMessage());
    }

    @Test
    void 커스텀_구분자_음수() {
        //given
        String input = "//;\\n1;-2;3";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.NEGATIVE_NUMBER, exception.getMessage());
    }

    @Test
    void 기본_구분자_문자() {
        //given
        String input = "1,2,a";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.INVALID_INPUT, exception.getMessage());
    }

    @Test
    void 커스텀_구분자_문자() {
        //given
        String input = "//;\\n1;2;a";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.INVALID_INPUT, exception.getMessage());
    }

    @Test
    void 기본_구분자_연속된_구분자() {
        //given
        String input = "1,,2";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.CONSECUTIVE_DELIMITERS, exception.getMessage());
    }

    @Test
    void 커스텀_구분자_연속된_구분자() {
        //given
        String input = "//;\\n1;;2";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.CONSECUTIVE_DELIMITERS, exception.getMessage());
    }

    @Test
    void 커스텀_구분자_연속된_구분자_구분자를_여러_개_사용할_경우() {
        //given
        String input = "//;*^\\n1;2;**3";

        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            delimiterCalculator.calculate(input);
        });
        assertEquals(ErrorMessage.CONSECUTIVE_DELIMITERS, exception.getMessage());
    }
}