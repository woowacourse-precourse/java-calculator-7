package calculator.domain;

import calculator.validator.CalculatorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void 초기화() {
        CalculatorValidator validator = new CalculatorValidator();
        calculator = new Calculator(validator);
    }

    @Test
    void 정수들의_합계_계산() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = calculator.sumInteger(integers);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    void 문자열을_정수로_파싱() {
        String[] inputArray = {"1", "2", "3", "4", "5"};
        List<Integer> integers = calculator.parseStringToInteger(inputArray);
        assertThat(integers).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void 구분자_제거() {
        String inputWithoutDeclare = "1;2,3";
        Character customSeparator = ';';
        String[] resultArray = calculator.removeSeparators(inputWithoutDeclare, customSeparator);
        assertThat(resultArray).containsExactly("1", "2", "3");
    }

    @Test
    void 선언부_제거_커스텀구분자_존재시() {
        String input = "//;\n1;2;3";
        Character customSeparator = ';';
        String resultWithoutDeclare = calculator.removeDeclarePart(input, customSeparator);
        assertThat(resultWithoutDeclare).isEqualTo("1;2;3");
    }

    @Test
    void 선언부_제거_커스텀구분자_없을시() {
        String input = "1,2,3";
        Character customSeparator = null;
        String resultWithoutDeclare = calculator.removeDeclarePart(input, customSeparator);
        assertThat(resultWithoutDeclare).isEqualTo("1,2,3");
    }

    @Test
    void 커스텀_구분자_추출_존재할시() {
        String input = "//;\n1;2;3";
        Character separator = calculator.extractCustomSeparator(input);
        assertThat(separator).isEqualTo(';');
    }

    @Test
    void 커스텀_구분자_추출_없을시() {
        String input = "1,2,3";
        Character separator = calculator.extractCustomSeparator(input);
        assertThat(separator).isNull();
    }
}
