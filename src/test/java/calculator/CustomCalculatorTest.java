package calculator;

import calculator.Interface.Calculator;
import calculator.Model.CalculatorModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomCalculatorTest {

    @Test
    void Test_Sum() {
        Calculator calculator = new CalculatorModel();
        String result = calculator.calculateSum(new String[]{"1", "2", "3", "4"});
        assertThat(result).isEqualTo("10");
    }

    @Test
    void Test_Void_Array_Sum() {
        Calculator calculator = new CalculatorModel();
        String result = calculator.calculateSum(new String[]{});
        assertThat(result).isEqualTo("0");
    }

    @Test
    void Single_Number_Sum() {
        Calculator calculator = new CalculatorModel();
        String result = calculator.calculateSum(new String[]{"5"});
        assertThat(result).isEqualTo("5");
    }

    @Test
    void Very_Big_Number_Sum() {
        Calculator calculator = new CalculatorModel();
        String result = calculator.calculateSum(new String[]{"100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "1"});
        assertThat(result).isEqualTo("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    }
}
