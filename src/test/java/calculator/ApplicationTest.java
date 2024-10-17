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
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀 구문자 안에 탈출 문자")
    void Test6() {
        assertSimpleTest(() -> {
            run("//\\\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("자릿수가 큰 숫자 합")
    void test7() {
        assertSimpleTest(() -> {
            run("100:200");
            assertThat(output()).contains("결과 : 300");
        });
    }

    @Test
    @DisplayName("커스텀구분자 0")
    void test8() {
        assertSimpleTest(() -> {
            run("//0\\n0100:200");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("커스텀구분자 숫자")
    void test9() {
        assertSimpleTest(() -> {
            run("1//1\\n111111111111");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 옆에 숫자")
    void test10() {
        assertSimpleTest(() -> {
            run("51//1\\n15");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("예외 테스트 : 커스텀 구문자 사이에 값 미존재")
    void exceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 입력에 양수가 아닌 0추가")
    void exceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0100:0200"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("커스텀 구분자 옆에 숫자 - 2")
    void test11() {
        assertSimpleTest(() -> {
            run("5//1\\n5");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
