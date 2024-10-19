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
    void 커스텀_구분자와_기본_구분자_함께_사용() {
        assertSimpleTest(() -> {
            run("//%\\n3%2:74,66");
            assertThat(output()).contains("결과 : 145");
        });
    }

    @Test
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("12,453,112:1234,1234:654");
            assertThat(output()).contains("결과 : 3699");
        });
    }

    @Test
    void 커스텀_구분자와_빈문자열_처리() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 빈문자열_처리() {
        assertSimpleTest(() -> {
            run("\n");              // input = "" : 아무것도 입력하지 않고 엔터를 친 경우
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자만_처리() {
        assertSimpleTest(() -> {
            run(":,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_지정_및_구분자만_처리() {
        assertSimpleTest(() -> {
            run("//;\\n;:,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 띄어쓰기_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
