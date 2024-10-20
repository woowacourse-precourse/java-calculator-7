package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("빈 리스트인 경우")
    void testIsEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        Calculator calculator = new Calculator(emptyList);
        int sum = calculator.getSum();

        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 있는 리스트인 경우")
    void testIsExistList() {
        List<Integer> emptyList = Arrays.asList(1, 2, 3, 4);
        Calculator calculator = new Calculator(emptyList);
        int sum = calculator.getSum();

        assertThat(sum).isEqualTo(10);
    }

}