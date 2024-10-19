package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Model.Calculator;
import calculator.Model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;
    private Number number;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        number = new Number();
    }

    @Test
    @DisplayName("합계 출력1")
    public void 합계를_출력1() {
        number.getInputText("4:7");
        assertEquals(calculator.calcSum(number), 11);
    }
    @Test
    @DisplayName("합계 출력2")
    public void 합계를_출력2() {
        number.getInputText("234:456,789");
        assertEquals(calculator.calcSum(number), 1479);
    }
    @Test
    @DisplayName("합계 출력3")
    public void 합계를_출력3() {
        number.getInputText("//;\n-534;-567;1882");
        assertEquals(calculator.calcSum(number), 781);
    }

    @Test
    @DisplayName("공백 입력")
    public void 공백_입력() {
        number.getInputText("");
        assertEquals(calculator.calcSum(number), 0);
    }

    @Test
    @DisplayName("최대치 초과하여 예외 발생")
    public void 정수형_최대치_초과() {
        number.getInputText("2147483647:5");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calcSum(number);
        });
    }

    @Test
    @DisplayName("최소치 초과하여 예외 발생")
    public void 정수형_최소치_초과() {
        number.getInputText("-2147483648:-5");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calcSum(number);
        });
    }
}
