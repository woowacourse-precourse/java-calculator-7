package calculator.domain;


import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

    @Test
    void 숫자_합_계산(){
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> numbers = Arrays.asList(1, 3, 2, 5, 22, 4, 7);
        long expected = 44;

        long result = resultCalculator.getSum(numbers);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void 숫자_합_배열_크기가_0인경우(){
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> numbers = Arrays.asList();
        long expected = 0;

        long result = resultCalculator.getSum(numbers);

        Assertions.assertThat(result).isEqualTo(expected);
    }


}
