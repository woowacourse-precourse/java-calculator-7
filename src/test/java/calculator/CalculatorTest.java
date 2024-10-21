package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 잘_동작되는_테스트() {
        assertEquals(0, calculator.add(""));
        assertEquals(3, calculator.add("//;\\n1;2"));
    }

    @Test
    void 음수가_들어오는_테스트() {
        assertThatThrownBy(() -> calculator.add("-1,-2,3,-4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_값이_들어오는_테스트() {
        assertThatThrownBy(() -> calculator.add("첫번째,과제,쉽지않다."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바르지_않은_커스텀_구분자_테스트() {
        assertThatThrownBy(() -> calculator.add("//;1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어지지_않은_구분자_테스트() {
        assertThatThrownBy(() -> calculator.add("1,2'3.4"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}