package binaryOperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlusOperatorTest {

    public static final BinaryOperator operator = new PlusOperator();
    @Test
    @DisplayName("덧셈 연산")
    void plus() {
        assertThat(operator.operate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("덧셈 연산 스트림 적용")
    void plus_stream() {
        //given
        List<String> numbers = new ArrayList<>(List.of("1", "2", "3", "4"));
        //when
        int result = numbers.stream().map(Integer::parseInt).reduce(0, operator::operate);
        //then
        assertThat(result).isEqualTo(10);
    }
}