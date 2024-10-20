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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void test1() { //음수 테스트 2
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test2() { //예외 구분자 사용(숫자 구분자는 허용x)
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n//2\\n3;2;1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test3() { //공백 구분자 - 허용 x
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test4() { //여러개의 피연산자
        assertSimpleTest(() -> {
            run("//;\\n1;5;2:234234,551");
            assertThat(output()).contains("결과 : 234793");
        });
    }

    @Test
    void test5() { //커스텁 구분자 테스트2
        assertSimpleTest(() -> {
            run("//[\\n4[5,1");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void test6() { //커스텀 구분자 양식 오류1
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test7() { //커스텀 구분자 양식 오류1
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test8() { //영어 사용
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,h,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
