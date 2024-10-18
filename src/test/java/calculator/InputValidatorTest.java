package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void isDefaultDelimiterTest() {
        InputValidator inputValidator = new InputValidator();
        DelimiterType result;

        result = inputValidator.isValidInput("1,2,3");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

        result = inputValidator.isValidInput("1:2:3");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

        result = inputValidator.isValidInput("1,3:2");
        assertThat(result).isEqualTo(DelimiterType.DEFAULT);

    }

    @Test
    void isCustomDelimiter() {
        InputValidator inputValidator = new InputValidator();
        DelimiterType result;

        result = inputValidator.isValidInput("//;\\n1");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("//;\\n1;2;3");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("//3\\n333");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("//3\\n43331");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("//o\\n1o2o3");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("//-3\\n2-33-32");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

        result = inputValidator.isValidInput("// \\n2 3 4");
        assertThat(result).isEqualTo(DelimiterType.CUSTOM);

    }

}
