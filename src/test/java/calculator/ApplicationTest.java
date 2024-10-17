package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("커스텀 구분자를 사용할 경우")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("음수일 경우")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("실수일 경우")
    void 실수_테스트() {
        assertSimpleTest(() -> {
            run("1.2:1.3,1"); // 실수도 계산 가능
            assertThat(output()).contains("결과 : 3.5");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자일 경우")
    void 커스텀_구분자_숫자() {
        assertSimpleTest(() -> {
            run("//1\\n21312"); // 1을 구분자로 판단
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 점일 경우")
    void 커스텀_구분자_점() {
        assertSimpleTest(() -> {
            run("//.\\n2.1.3.999"); // .을 구분자로 판단
            assertThat(output()).contains("결과 : 1005");
        });
    }

    @Test
    @DisplayName("빈 문자열")
    void 빈_문자열() { // Console.readLine()에서 오류가 나는디?
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀 구분자의 형식이 맞지 않을 경우")
    void 커스텀_구분자_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n")) // substring으로 자르면, OutOfBounds가 생긴다.
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("//"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 빈 문자열만 있을 경우")
    void 커스텀_구분자와_빈_문자열() {
        assertSimpleTest(() -> {
            run("//e\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("숫자 사이에 공백문자가 있을 경우")
    void 숫자_사이_공백문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("    1.1, 1 :  9  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("공백 문자만 있을 경우")
    void 공백문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("       "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
