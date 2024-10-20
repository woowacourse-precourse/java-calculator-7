package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @Test
    void sumTest() {
        CalculatorService calculatorService = new CalculatorService();
        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertEquals(6, calculatorService.sum(integers)
                .get());
    }
}