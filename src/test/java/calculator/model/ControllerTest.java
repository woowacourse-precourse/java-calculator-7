package calculator.model;

import calculator.controller.Controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller(
            new Delimiter(),
            new Extractor(),
            new Numbers()
    );

    @Test
    @DisplayName("Controller 커스텀 구분자 통합테스트")
    void controllerCustomCustomTest() {
        //given
        String input = "//;\\n4;3;2";

        //when
        Integer result = controller.execute(input);

        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("Controller 기본 구분자 통합테스트")
    void controllerDefaultDelimiterTest() {
        //given
        String input = "4:5,6";

        //when
        Integer result = controller.execute(input);

        //then
        assertThat(result).isEqualTo(15);
    }
}