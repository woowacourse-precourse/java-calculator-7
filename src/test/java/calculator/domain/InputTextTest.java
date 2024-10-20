package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class InputTextTest {

    private String input = "//!?!\\n12,34:56!?!78:910";

    @Test
    void 문자와_구분자_분리_테스트() {
        InputText inputText = new InputText("test");
        String result = inputText.divideTextAndSeparateList(input);

        assertThat(result).isEqualTo("12,34:56!?!78:910");
        assertThat(inputText.getSeparatorList()).contains("!?!");
    }
}
