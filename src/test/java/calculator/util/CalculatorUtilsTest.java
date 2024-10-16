package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CalculatorUtilsTest {

    @Test
    void getInput_함수_테스트() {
        String userInput = "12,3,1:33,:3";

        InputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        Assertions.assertThat(CalculatorUtils.getInput()).isEqualTo(userInput);
    }

}