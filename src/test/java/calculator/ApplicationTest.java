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

    @Test
    public void 숫자_구분자_사용(){
        assertSimpleTest(()->{
            run("//1\\n2:213");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    public void 탈출_문자_사용(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1\\2:3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 탈출_문자_구분자_사용(){
        assertSimpleTest(() -> {
            run("//\\\\n1\\2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    public void 마침표_구분자_사용(){
        assertSimpleTest(()->{
            run("//.\\n1.2.4:3");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    public void 따옴표_구분자_사용(){
        assertSimpleTest(()->{
            run("//\"\\n1\"2\"4:3");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    public void 구분자_사이에_문자열_없음(){
        assertSimpleTest(() -> {
            run("1,:2");
            assertThat(output()).contains("결과 : 3");
        });
    }
}
