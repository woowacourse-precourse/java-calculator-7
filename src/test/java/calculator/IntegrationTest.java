package calculator;

import calculator.global.AppConfig;
import calculator.presentation.InputData;
import calculator.presentation.TextCalculatorController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegrationTest {


    @DisplayName("사용자가 1,2:3 을 입력하면 총 합인 6을 반환한다")
    @Test
    void functionalTest() {

        AppConfig config = new AppConfig();
        TextCalculatorController controller = config.controller();

        InputData inputData = new InputData("1,2:3");
        Long result = controller.getSumTotal(inputData);

        Assertions.assertThat(result).isEqualTo(6L);
    }

    @DisplayName("사용자가 1,2;3 을 입력하면 예외를 반환한다")
    @Test
    void exceptionTest() {

        AppConfig config = new AppConfig();
        TextCalculatorController controller = config.controller();

        InputData inputData = new InputData("1,2;3");
        Assertions.assertThatThrownBy(() -> controller.getSumTotal(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 //;\\n1,2;3 을 입력하면 총 합인 6을 반환한다")
    @Test
    void customSeparatorTest() {

        AppConfig config = new AppConfig();
        TextCalculatorController controller = config.controller();

        InputData inputData = new InputData("//;\\n1,2;3");
        Long result = controller.getSumTotal(inputData);

        Assertions.assertThat(result).isEqualTo(6L);
    }
}
