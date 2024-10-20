package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_사용_정수_대상() {
        assertSimpleTest(() -> {
            run("1;2,3;4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 기본_구분자_사용_실수_대상() {
        assertSimpleTest(() -> {
            run("1.1;2.2,3.3;4.4,5.5");
            assertThat(output()).contains("결과 : 16.5");
        });
    }

    @Test
    void 복수글자의_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//aa\\n1aa2aa3;4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 정규식_메타_문자_대상_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//?\\n1?2?3?4?5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 복수개의_정규식_메타_문자_대상_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//^$[]{}().*+?|/\\\\n1^$[]{}().*+?|/\\2^$[]{}().*+?|/\\3,4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void Decimal_형식_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1.0;2.1;3.2");
            assertThat(output()).contains("결과 : 6.3");
        });
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run("//   \\n1   2   3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
