package calculator;

import static calculator.view.InputView.getNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.service.CustomSeperator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private CustomSeperator customSeperator;

    @BeforeEach
    void settUpCustomSeperator() {
        customSeperator = new CustomSeperator();
    }

    @Test
    @DisplayName("실수를 입력 할 시 값 비교")
    void 실수_입력시_값_비교() {
        customSeperator.updateCustomSeperator("//!\\n1.3,2.2:3");
        List<Double> number = getNumber("//!\\n1.3,2.2:3");

        assertEquals(number.stream().mapToDouble(Double::doubleValue).sum(), 6.5);
    }

    @Test
    @DisplayName("정수를 입력 할 시 값 비교")
    void 정수_입력시_값_비교() {
        customSeperator.updateCustomSeperator("//!\\n3,2:1!1");
        List<Double> number = getNumber("//!\\n3,2:1!1");

        assertEquals(number.stream().mapToDouble(Double::doubleValue).sum(), 7);
    }

}
