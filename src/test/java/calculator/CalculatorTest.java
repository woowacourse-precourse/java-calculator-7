package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest extends NsTest {

    @Test
    @DisplayName("커스텀 구분자를 추가한 문자열")
    void 커스텀_구분자를_추가한_문자열() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("커스텀 구분자만 있는 문자열")
    void 커스텀_구분자만_있는_문자열() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("숫자만 있는 문자열")
    void 숫자_문자열() {
        assertSimpleTest(() -> {
            run("123456");
            assertThat(output()).contains("결과 : 123456");
        });
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 문자열")
    void 커스텀_구분자_사용_문자열() {
        assertSimpleTest(() -> {
            run("//;\\n1,2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Test
    @DisplayName("예외_포함되지 않은 구분자 사용한 문자열")
    void 포함되지_않는_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;3@4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("예외_커스텀 구분자가 두글자인 문자열")
    void 커스텀_구분자_두개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외_커스텀 구분자 형식에 \\n이 없는 문자열")
    void 잘못된_형식_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
