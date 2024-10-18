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

    @DisplayName("문자열이 커스텀 구분자를 지정했다.")
    @Test
    void test3() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("//;\\n1;3;4");
            assertThat(inputString.containsCustomSeperator()).isTrue();
        });
    }

    @DisplayName("문자열이 커스텀 구분자를 지정하지 않았다.")
    @Test
    void test4() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("1,3:2");
            assertThat(inputString.containsCustomSeperator()).isFalse();
        });
    }

    @DisplayName("문자열에서 커스텀 구분자를 추출할 수 있다.")
    @Test
    void test5() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("//;\\n1;3;4");
            assertThat(inputString.extractCustomSeperator()).isEqualTo(';');
        });
    }
}