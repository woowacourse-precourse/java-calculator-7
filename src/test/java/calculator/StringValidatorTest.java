package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StringValidatorTest {

    private final StringValidator validator = new StringValidator();

    @Test
    void 숫자_커스텀_구분자_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("//1\\n1,2,3")
        );
        assertEquals("숫자는 커스텀 구분자로 지정할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_형식_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("//;2;3")
        );
        assertEquals("커스텀 구분자 형식(//커스텀구분자\\n)을 준수해주세요.", exception.getMessage());
    }

    @Test
    void 입력이_구분자로_종료할_경우_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("1,2,")
        );
        assertEquals("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다.", exception.getMessage());
    }

    @Test
    void 입력이_커스텀_구분자로_종료할_경우_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("//;\\n1;2;")
        );
        assertEquals("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다.", exception.getMessage());
    }

    @Test
    void 입력이_구분자로_시작할_경우_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate(",1,2,3")
        );
        assertEquals("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 시작하고 있습니다.", exception.getMessage());
    }

    @Test
    void 입력이_커스텀_구분자로_시작할_경우_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("//;\\n;2;3")
        );
        assertEquals("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 시작하고 있습니다.", exception.getMessage());
    }

    @Test
    void 비어있는_입력_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validate("")
        );
        assertEquals("입력이 이루어지지 않았습니다.", exception.getMessage());
    }

    @Test
    void 비어있는_숫자_입력_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validateNumbers(Arrays.asList("", "2", "3"))
        );
        assertEquals("양수입력이 비어있습니다.", exception.getMessage());
    }

    @Test
    void 숫자_이외의_입력_검증() {
        CalculatorException exception = assertThrows(CalculatorException.class, () ->
                validator.validateNumbers(Arrays.asList("1", "abc", "3"))
        );
        assertEquals("올바르지 않은 양수 입력입니다: abc", exception.getMessage());
    }
}
