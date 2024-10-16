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
    void 커스텀_구분자_사용_실패1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용_실패2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_문자열_파싱_실패_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_문자열_파싱_실패_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_문자열_파싱_성공_테스트1() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 입력_문자열_파싱_성공_테스트2() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 입력_문자열_파싱_성공_테스트3() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_혼용_성공_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_혼용_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,3:a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 단일_커스텀_구분자_성공_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 단일_커스텀_구분자_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;ㅁ;4;5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 다중_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;?>\\n1;2;3;4;5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수_판별_실패_케이스1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:1.743,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수_판별_실패_케이스2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:0,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수_판별_실패_케이스3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:-4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수_판별_실패_케이스4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,?:4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수_판별_실패_케이스5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:ㅁ,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
