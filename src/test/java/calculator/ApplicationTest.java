package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 입력받은_문자열이_커스텀_구분자를_고려해야_하는_문자열인_경우() {
        assertThat(Application.isStringWithCustomDelimiter("//a\\n1a2a3")).isEqualTo(true);
    }

    @Test
    void 입력받은_문자열이_커스텀_구분자를_고려해야_하는_문자열이_아닌_경우() {
        assertThat(Application.isStringWithCustomDelimiter("1,2,3")).isEqualTo(false);
    }

    @Test
    void 기본_구분자를_기준으로_입력받은_문자열을_분리하는_경우() {
        assertThat(Application.splitString("3,4:5")).isEqualTo(new String[]{"3", "4", "5"});
    }

    @Test
    void 기본_구분자와_커스텀_구분자를_모두_고려하여_입력받은_문자열을_분리하는_경우() {
        assertThat(Application.splitString("//@\\n3,4:5@6")).isEqualTo(new String[]{"3", "4", "5", "6"});
    }

    @Test
    void 커스텀_구분자가_기본_구분자와_동일한_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//,\\n1,2:3"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("//:\\n1,2:3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_기본_구분자와_동일하지_않은_경우() {
        assertSimpleTest(() -> {
            run("//@\\n1,2:3@4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자를_지정하지_않고_빈_문자열을_입력하는_경우() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자를_지정하고_빈_문자열을_입력하는_경우() {
        assertSimpleTest(() -> {
            run("//a\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 분리된_대상이_빈_문자열인_경우() {
        assertSimpleTest(() -> {
            run("1::::1");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
