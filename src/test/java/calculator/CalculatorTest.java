package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        ArrayList<Character> separators = new ArrayList<>(List.of(',', ':'));
        calculator = new Calculator("1,2:3", separators);
    }

    @Test
    @DisplayName("기본 구분자 사용 테스트")
    void testCalculateValidInput() {

        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 사용 테스트")
    void testCalculateWithCustomSeparator() {
        ArrayList<Character> separators = new ArrayList<>(List.of(',', ':', ';'));
        calculator = new Calculator("1,2:3", separators);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자가 아닌 문자 예외 테스트")
    void testCalculateWithInvalidInput() {
        ArrayList<Character> separators = new ArrayList<>(List.of(',', ':'));
        calculator = new Calculator("1,a:3", separators);

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate());
    }
}