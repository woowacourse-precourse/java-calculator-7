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
    void 커스텀_구분자에_정규표현식_사용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_여러문자() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_외에_숫자_안주어짐() {
        assertSimpleTest(() -> {
            run("//;|\\n");
            assertThat(output().contains("결과 : 0"));
        });
    }

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output().contains("결과 : 0"));
        });
    }

    @Test
    void 숫자가_아닌_다른_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\na;;b;;c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_문자_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//@@\\na;b;c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a@@b@@c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
