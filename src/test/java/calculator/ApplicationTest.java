package calculator;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈문자열_처리() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용(){
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");

            run("1:2:3");
            assertThat(output()).contains("결과: 6");

            run("1,3:2");
            assertThat(output()).contains("결과: 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");

            run("//;\\n1;2;3");
            assertThat(output()).contains("결과: 6");

            run("//3\\n333");
            assertThat(output()).contains("결과: 6");

            run("//3\\n43331");
            assertThat(output()).contains("결과: 6");

            run("//o\\n1o2o3");
            assertThat(output()).contains("결과: 6");

            run("//-3\\n2-33-32");
            assertThat(output()).contains("결과: 7");

            run("// \\n2 3 4");
            assertThat(output()).contains("결과: 9");

        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2  ,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
