package calculator.service;

import calculator.business.TextCalculatorService;
import calculator.business.TextCalculatorServiceImpl;
import calculator.business.command.CalculateCommand;
import calculator.domain.service.Calculator;
import calculator.presentation.InputData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextCalculatorServiceTest {


    @DisplayName("1,2:3 을 입력하면 총 합인 6을 반환한다")
    @Test
    void serviceTest() {

        // given
        TextCalculatorService service = new TextCalculatorServiceImpl(new Calculator());
        InputData inputData = new InputData("1,2:3");

        // when
        CalculateCommand command = new CalculateCommand(inputData);
        Long result = service.calculateSumTotal(command);

        // then
        Assertions.assertThat(result).isEqualTo(6L);
    }

    @DisplayName("//;\\n1,2:3;4 을 입력하면 총 합인 10을 반환한다")
    @Test
    void customSeparatorTest() {

        // given
        TextCalculatorService service = new TextCalculatorServiceImpl(new Calculator());
        InputData inputData = new InputData("//;\\n1,2;3:4");

        // when
        CalculateCommand command = new CalculateCommand(inputData);
        Long result = service.calculateSumTotal(command);

        // then
        Assertions.assertThat(result).isEqualTo(10L);
    }

    @DisplayName("//;\\n1,2w3;4 을 입력하면 IllegalArgumentException 을 반환한다")
    @Test
    void exceptionTest() {

        // given
        TextCalculatorService service = new TextCalculatorServiceImpl(new Calculator());
        InputData inputData = new InputData("//;\\n1,2w3;4");

        // when
        CalculateCommand command = new CalculateCommand(inputData);

        // then
        Assertions.assertThatThrownBy(() -> service.calculateSumTotal(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
