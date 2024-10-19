package calculator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class StringValidatorTest {

    @Test
    public void customDelimiterTest() {
        String userInput = "//;\\n1;2;3";
        assertThat(StringValidator.customDelimiterValidator(userInput)).isEqualTo("//");
    }

}