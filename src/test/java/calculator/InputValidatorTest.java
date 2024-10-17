package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void isDefaultDelimiterTest(){
        InputValidator inputValidator = new InputValidator();
        DelimiterType result;

        result = inputValidator.isValidInput("1,2,3");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

        result = inputValidator.isValidInput("1:2:3");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

        result = inputValidator.isValidInput("1,3:2");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

    }
}
