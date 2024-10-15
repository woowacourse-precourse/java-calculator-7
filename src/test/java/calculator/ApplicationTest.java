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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    /*
        ---------------------------------------------------------------
        my test
    */

    @Test
    void exceptionTest(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//a\\n1a2a3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void sampleTest(){
        assertSimpleTest(() -> run(""));
        assertThat(output()).contains("결과 : 0");
        assertSimpleTest(() -> run("1,2"));
        assertThat(output()).contains("결과 : 3");
        assertSimpleTest(() -> run("1,2,3"));
        assertThat(output()).contains("결과 : 6");
        assertSimpleTest(() -> run("1,2:3"));
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void calcTest(){
        String input = "//+\\n1+2+3+4+5+6+7+8+9+10";
        assertSimpleTest(() -> run(input));
        assertThat(output()).contains("결과 : 55");
    }
}
