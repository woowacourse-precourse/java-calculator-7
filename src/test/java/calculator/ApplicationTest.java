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
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 엣지_제대로_된_결과값() {
        assertSimpleTest(() -> {
            run("\n"); // 줄내림까지
            assertThat(output().startsWith("결과 : 0"));
        });
    }

    @Test
    void 제대로_된_결과값() {
        assertSimpleTest(() -> {
            run("1:2:3\n");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 커스텀구분자_사용_제대로_된_결과값() {
        assertSimpleTest(() -> {
            run("//a\\n1:2,3a4\n");
            assertThat(output().contains("결과 : 10"));
        });
    }

    @Test
    void 제대로_된_결과값_edge() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output().contains("결과 : 1"));
        });
    }

    @Test
    void 여러개_구분자_존재하는_경우(){
        assertSimpleTest(() -> {
            run("//a,b\\n1a2a3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 여러개의_구분자에서_음수가_나오는_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a,b,c\n-1a2b3c4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}


