package calculator.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.CalculatorRequest;
import calculator.dto.CalculatorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void 기본_구분자_정상_실행() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of("[,:]", "1,2:3");
            int expected = 6;
            CalculatorResponse response = calculatorService.calculateSum(request);
            assertThat(response.result()).isEqualTo(expected);
        });
    }

    @Test
    void 커스텀_구분자_정상_실행() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(",;", "1,;2,;3");
            int expected = 6;
            CalculatorResponse response = calculatorService.calculateSum(request);
            assertThat(response.result()).isEqualTo(expected);
        });
    }

    @Test
    void 빈입력_정상_실행() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of("[,:]", "");
            int expected = 0;
            CalculatorResponse response = calculatorService.calculateSum(request);
            assertThat(response.result()).isEqualTo(expected);
        });
    }

    @Test
    void 음수_입력_예외_발생() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(";", "-1;2;3");

            assertThatThrownBy(() -> calculatorService.calculateSum(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 문자_입력_예외_발생() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(";", "1;2;n");

            assertThatThrownBy(() -> calculatorService.calculateSum(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자로_끝날_시_예외_발생() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of("[,:]", "1:2,3,");

            assertThatThrownBy(() -> calculatorService.calculateSum(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
