package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {
    @Test
    void 커스텀_구분자_여부_확인1() {
        assertSimpleTest(() -> {
            String input = "1,2:3";
            boolean result = Calculator.extractCustomSeparators(input);
            assertThat(result).isFalse();
        });
    }

    @Test
    void 커스텀_구분자_여부_확인2() {
        assertSimpleTest(() -> {
            String input = "//;\\n1";
            boolean result = Calculator.extractCustomSeparators(input);
            assertThat(result).isTrue();
        });
    }

    @Test
    void 커스텀_구분자_추가_여부_확인() {
        assertSimpleTest(() -> {
            String input = "//;\\n1";
            Calculator.extractCustomSeparators(input);
            assertThat(Calculator.separators).containsAll(new HashSet<>(Arrays.asList(",", ":", ";")));
        });
    }

    @Test
    void 커스텀_구분자_추가_여부_확인2() {
        assertSimpleTest(() -> {
            String input = "//-\\n//;\\n1-2,3;4:5";
            Calculator.extractCustomSeparators(input);
            assertThat(Calculator.separators).containsAll(new HashSet<>(Arrays.asList(":", ";", ",", "-")));
        });
    }

    @Test
    void 빈_문자열_결과_확인() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void ZERO_입력시_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_2개_존재() {
        assertSimpleTest(() -> {
            run("//-\\n//;\\n1-2,3;4:5");
            assertThat(output()).contains("결과 : 15");
        });

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
