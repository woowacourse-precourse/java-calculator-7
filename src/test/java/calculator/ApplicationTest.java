package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    void 다양한_커스텀_구분자(){
        assertSimpleTest(() -> {
            run("//;\\n//-\\n1;2-3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }
    @Test
    void 커스텀_구분자_특수기호(){
        assertSimpleTest(() -> {
            run("//\\\\n1\\2");
            assertThat(output()).contains("결과 : 3");
        });
    }


    @Test
    void 네자리숫자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;9999");
            assertThat(output()).contains("결과 : 10000");
        });
    }

    @Test
    void 공백() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 양수가_아닌_정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
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
    void 예외_테스트_숫자구분자(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\n,1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///1\n,1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
