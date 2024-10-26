package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2,6");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 구분자_없는_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23/43-23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 피연산자_없는_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///*ㅏ*!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력문자열_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 공백_또는_null_입력된_경우() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });

        assertSimpleTest(() -> {
            run(null);
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
