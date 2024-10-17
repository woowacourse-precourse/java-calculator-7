package calculator;

import calculator.controller.CalculateController;
import calculator.service.CalculateService;
import calculator.service.SplitService;
import calculator.validator.InputValid;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

public class ControllerTest extends NsTest {

    private CalculateController calculateController = CalculateController.getInstance();
    @Test
    void 기본_구분자로_숫자_더하기() {
        // Given
        String input = "1,2,3";

        // When
        String result = calculateController.process(input);

        // Then
        Assertions.assertEquals("6", result);
    }

    @Test
    void 커스텀_구분자로_숫자_더하기() {
        // Given
        String input = "//;\\n1;2;3";

        // When
        String result = calculateController.process(input);

        // Then
        Assertions.assertEquals("6", result);
    }

    @Test
    void 빈_문자열_입력시_예외_발생() {
        // Given
        String input = "";

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateController.process(input));
    }

    @Test
    void 음수_입력시_예외_발생() {
        // Given
        String input = "1,-2,3";

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateController.process(input));
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
