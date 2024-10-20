package calculator.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.application.impl.StringCalculatorSeparateService;
import java.util.List;
import org.junit.jupiter.api.Test;

class SeparateServiceUnitTest {

    SeparateService separateService = new StringCalculatorSeparateService();

    @Test
    void givenAnyStringCommand_whenSeparate_thenReturnList() {
        // given
        String command = "";

        // when
        List<String> result = separateService.separate(command);

        // then
        assertThat(result).isInstanceOf(List.class);
    }

    @Test
    void givenNullCommand_whenSeparate_thenReturnList() {
        // given
        String command = null;

        // when
        List<String> result = separateService.separate(command);

        // then
        assertThat(result).isInstanceOf(List.class);
    }

    @Test
    void givenInvalidCommand_whenSeparate_thenReturnError() {
        // given
        String command = "\\n";

        // when, then
        assertThatThrownBy(() -> separateService.separate(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

}