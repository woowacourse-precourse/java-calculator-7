package calculator.initialTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;
    ArrayList<Integer> savedNumberRepository;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
        savedNumberRepository = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    }

    @Test
    void 더하기() {

        int sum = calculator.allSum(savedNumberRepository);
        Assertions.assertEquals(15, sum);
    }


}


class Calculator {

    public int allSum(ArrayList<Integer> savedNumberRepository) {
        int sum = 0;
        for (int i = 0; i < savedNumberRepository.size(); i++) {
            sum += savedNumberRepository.get(i);
        }

        return sum;
    }


}