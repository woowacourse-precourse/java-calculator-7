package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void defaultInput() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        int result = calculator.calculate("1,2,3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void customInput() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        int result = calculator.calculate("//;\\n1,2,3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void customInput1() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        int result = calculator.calculate("//;\\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void customInput2() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        int result = calculator.calculate("//;\\n1:2,3,4");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void custom3() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        int result = calculator.calculate("//;\\n1:2,3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void negativeInput() {
        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        Assertions.assertThatThrownBy(() -> calculator.calculate("//;\\n-1:2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}