package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputStringTest {
    @DisplayName("문자열이 공백인지 확인한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString(" ");
            assertThat(inputString.isBlank()).isTrue();
        });
    }

    @DisplayName("문자열이 빈 문자열인지 확인한다.")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("");
            assertThat(inputString.isBlank()).isTrue();
        });
    }

}