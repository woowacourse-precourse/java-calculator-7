import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculateStrategy.Calculate;
import calculateStrategy.integerCalculate;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("계산 기능 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CalculateTest {
    @Test
    void 리스트의_숫자들의_합을_올바르게_구한다() {
        //given
        Calculate calculate = new integerCalculate();
        List<Integer> operands = new ArrayList<>();
        operands.add(1);
        operands.add(3);
        operands.add(10);

        //when
        Integer addResult = calculate.add(operands);

        //then
        Assertions.assertThat(addResult).isEqualTo(14);
    }

    @Test
    void 숫자의_합이_정수범위를_넘어가면_예외가_발생한다() {
        //given
        Calculate calculate = new integerCalculate();
        List<Integer> operands = new ArrayList<>();
        operands.add(2147483647);
        operands.add(1);

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> calculate.add(operands));
        //then
        assertThat(e.getMessage()).isEqualTo("숫자의 합이 Integer 범위를 넘어간다");
    }
}
