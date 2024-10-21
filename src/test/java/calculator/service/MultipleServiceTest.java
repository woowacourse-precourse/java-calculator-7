package calculator.service;

import calculator.domain.SumCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleServiceTest {

    @Test
    @DisplayName("MultipleService 정상 동작 확인")
    void process() {
        // given
        String args = "//#\\n1,2#3:4";
        SumCalculator sumCalculator = new SumCalculator();
        MultipleService multipleService = new MultipleService(sumCalculator);
        int expect = 10;

        // when
        int result = multipleService.calculate(args);

        // then
        assertEquals(expect, result);
    }

}
