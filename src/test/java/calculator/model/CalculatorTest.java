package calculator.model;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 리스트의 합계를 반환한다.")
    public void 숫자_리스트를_전달하면_정확한_합계를_반환한다() {
        //given
        List<Number> numbers = Arrays.asList(1,2,3,4,5,10.5);

        //when
        double result = calculator.calculatorSum(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(25.5);
    }
}