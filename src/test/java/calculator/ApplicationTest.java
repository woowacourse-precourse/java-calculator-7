package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자가_없는_경우() {
        assertSimpleTest(() -> {
            run("1234");
            assertThat(output()).contains("결과 : 1234");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1:6:4", "//;\\n11"})
    void 커스텀_구분자_존재하나_사용_안함(String string) {
        assertSimpleTest(() -> {
            run(string);
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;5;6");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"// \\n1 2 3 9", "//R\\n1R6R3R5", "//가\\n2가10가3"})
    void 특수_커스텀_구분자_사용(String string) {
        assertSimpleTest(() -> {
            run(string);
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("0,2,0,4");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자로_문자열_시작_또는_끝() {
        assertSimpleTest(() -> {
            run("//#\\n#1#3#5#");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 구분자_사이_숫자_없음() {
        assertSimpleTest(() -> {
            run("7::6::::::4");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 기본_구분자를_커스텀_구분자로_지정() {
        assertSimpleTest(() -> {
            run("//,\\n1,3:6");
            assertThat(output()).contains("결과 : 10");
        });
    }



    @ParameterizedTest
    @ValueSource(strings = {"#\\n1#3#6", "//@3@4@5", "//&%@\\n32,165", "//5\\n"})
    void 커스텀_구분자_형식_오류(String string) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(string))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "//$\\n1!2!3!4"})
    void 구분자로_지정하지_않은_문자_포함(String string) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(string))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_10억_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
