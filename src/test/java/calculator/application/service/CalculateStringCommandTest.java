package calculator.application.service;

import static org.assertj.core.api.Assertions.*;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.application.validation.InputValidator;
import calculator.domain.service.AdditionService;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("CalculateStringCommand 테스트")
class CalculateStringCommandTest {

    private InputValidator inputValidator;
    private AdditionService additionService;
    private CalculateStringCommand calculateStringCommand;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
        additionService = new AdditionService();
        calculateStringCommand = new CalculateStringCommand(inputValidator, additionService);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 6",
        "1,2:3,4; 10",
        "10,20,30; 60",
        "//@\\n1,2@3; 6",
        "//&\\n5&10&15; 30",
        "//@\\n2; 2",
    })
    void 계산_후_결과를_도출(String input, BigInteger expectedResult) {
        // given
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when
        CalculationResponse calculationResponse = calculateStringCommand.calculate(
            calculationRequest);

        // then
        assertThat(calculationResponse.result()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "1,2,3!; 6",
        "1,2:3,,4; 10",
        ",10; 60",
        "//@\\n1,2@@3; 6",
        "//&\\n@5&15; 30",
    })
    void 잘못된_입력은_예외를_발생(String input, BigInteger expectedResult) {
        // given
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when
        assertThatThrownBy(() -> calculateStringCommand.calculate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class);
    }
}