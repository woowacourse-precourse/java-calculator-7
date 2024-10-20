package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @BeforeEach
    void setUp() {
        Application.delim = new StringBuilder(",:");
    }
    
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
    void 구분자_여러_문자_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;-(\\n1;-(2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자로_분리() {
        assertSimpleTest(() -> {
            run("1,2//;\\n3;4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자_혼재() {
        assertSimpleTest(() -> {
            run("1,2:3//;\\n4;5:6,7//$\\n8:9;10,11$12");
            assertThat(output()).contains("결과 : 78");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
