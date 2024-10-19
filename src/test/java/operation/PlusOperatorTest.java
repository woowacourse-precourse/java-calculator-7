package operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOperatorTest {

    public static final Operator operator = new PlusOperator();
    @Test
    @DisplayName("덧셈 연산")
    void plus() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2));
        //when
        int result = operator.operate(numbers);
        //then
        assertThat(result).isEqualTo(3);
    }
}