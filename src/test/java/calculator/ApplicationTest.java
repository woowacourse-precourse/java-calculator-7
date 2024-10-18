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

        assertSimpleTest(() -> {
            run("//;\\n1,2,3;4:5;6");
            assertThat(output()).contains("결과 : 21");
        });
        
        //알파벳 한글 사용 테스트 추가
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("1,2,3:4:5,6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_연속_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1--2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n1:2##3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_등록하지_않은_커스텀_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1'2:3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1[2]3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자열_앞_뒤_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1,2,3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;1,2:3,4:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//5\\n5,4,5,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
