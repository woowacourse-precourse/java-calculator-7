package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SumServiceTest {
    SumService sumService = SumService.getInstance();

    @Test
    public void testCalculate_noErrorText() {
        String noErrorString = "1:2:3,4";

        assertEquals(sumService.calculate(noErrorString), 10, "sumService: 계산 과정 오류");
    }

    @Test
    public void testCalculate_ErrorText() {
        String errorString = "1:2:34";

        assertThrows(IllegalArgumentException.class, () -> sumService.calculate(errorString),
                "sumService: 잘못된 문자열에 대해 오류가 발생하지 않음");
    }

    @Test
    public void testCalculate_blank() {
        String blank = "";

        assertEquals(sumService.calculate(blank), 0, "sumService: 공백 처리 실패");
    }
}
