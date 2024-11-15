package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_한_개만_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 숫자_여러_개_테스트() {
        assertSimpleTest(() -> {
            run("1,4,5:16:20");
            assertThat(output()).contains("결과 : 46");
        });
    }

    @Test
    void 구분자만_테스트() {
        assertSimpleTest(() -> {
            run(",,,::");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 잘못된_구분자_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1=4]!"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_글자_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1ㄱ4643r"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 커스텀_구분자_사용되는_경우_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n12;3;45");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    void 커스텀_구분자_있지만_사용되지_않는_경우_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자로_숫자가_들어오는_경우_테스트() {
        assertSimpleTest(() -> {
            run("//1\\n1");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
