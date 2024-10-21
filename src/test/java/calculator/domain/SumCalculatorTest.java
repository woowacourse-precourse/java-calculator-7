package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    List<String> list = new ArrayList<>();
    SumCalculator sumCalculator = new SumCalculator(list);

    @BeforeEach
    void init() {
        list.clear();
    }

    @Test
    void 계산_테스트() {
        list.add("1");
        list.add("3.0123456789");

        String result = sumCalculator.calculateSum();

        Assertions.assertTrue(result.equals("4.0123456789"));
    }

    @Test
    void 계산_테스트_2() {
        list.add("0123");
        list.add("0456");

        String result = sumCalculator.calculateSum();

        Assertions.assertTrue(result.equals("579"));
    }

    @Test
    void 계산_테스트_음수() {
        list.add("-1");
        list.add("1234567890");

        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.calculateSum());

    }

    @Test
    void 계산_테스트_0() {
        list.add("1");
        list.add("0");

        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.calculateSum());

    }
}