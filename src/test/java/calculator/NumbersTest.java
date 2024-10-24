package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    @DisplayName("Numbers 음수 검증")
    void validateTest() throws Exception{
        //given
        List<Double> numberList = new ArrayList<>();
        numberList.add(-1.0);
        numberList.add(2.0);
        numberList.add(3.0);
        //expect
        assertThrows(IllegalArgumentException.class, () -> {new Numbers(numberList);});
    }
    @Test
    @DisplayName("Numbers 덧셈 검증")
    void getSum() throws Exception{
        //given
        List<Double> numberList = new ArrayList<>();
        numberList.add(1.0);
        numberList.add(2.0);
        numberList.add(3.0);
        Numbers numbers = new Numbers(numberList);
        //when
        Double sum = numbers.getSum();
        //then
        assertEquals(6.0, sum);
    }
}