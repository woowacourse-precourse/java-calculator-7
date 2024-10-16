package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("스페이스바 구문자 테스트")
    void test1() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3,4 5");
            assertThat(output()).contains("결과 : 15");
        });
    }


    @Test
    @DisplayName("숫자 구문자 테스트")
    void test2() {
        assertSimpleTest(() -> {
            run("//5\\n1,2,3,4,5");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("커스텀 구문자 판단들을 모두 허용")
    void test3() {
        assertSimpleTest(() -> {
            run("///\\n // \\n //\\\\n //n\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("- 커스텀 구문자와 병행 사용")
    void test4() {
        assertSimpleTest(() -> {
            run("//-\\n,-5,-4,-3,-2,-1");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    @DisplayName("빈값 테스트")
    void test5() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("예외 테스트 : 중첩 커스텀 구문자")
    void exceptionTest1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("////5\\n\\n1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
        );

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
