package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("문자열 길이가 0일 경우, 0출력")
    public void case1() {

        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("쉼표 구분자 사용한 경우")
    public void case2() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("쉼표 구분자 사용한 경우")
    public void case3() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자를 사용한 경우")
    public void case4() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 사용한 경우")
    void case5() {
        assertSimpleTest(() -> {
            run("//;\\n1;3;2");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 모두 사용한 경우")
    void case6() {
        assertSimpleTest(() -> {
            run("//;\\n1,3;4");
            assertThat(output()).contains("결과 : 8");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 정의만 있는 경우, 0출력")
    void case7() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("구분자만 있는 경우, 0출력")
    void case8() {
        assertSimpleTest(() -> {
            run(",,:");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("예외: 음수를 입력한 경우")
    void errorCase1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 0을 입력한 경우")
    void errorCase2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,0,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: //만 있는 경우")
    void errorCase3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: \n만 있는 경우")
    void errorCase4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("2,3\\n"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 커스텀 구분자가 숫자인 경우")
    void errorCase5() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//3\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
