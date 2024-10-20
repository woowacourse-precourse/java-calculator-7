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
    void 쉼표_또는_클론_한자리수_확인(){
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 쉼표_또는_클론_두자리이상의_수_확인(){
        assertSimpleTest(() -> {
            run("1,24,540,400");
            assertThat(output()).contains("결과 : 965");
        });
    }

    @Test
    void 아무런_숫자가_들어가지_않을_때(){
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과 : 965");
        });
    }

    @Test
    void 첫번째_값_확인(){
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
