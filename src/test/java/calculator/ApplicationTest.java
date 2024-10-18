package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
// 아래는 새로 추가된 메서드
    @Test
    void 커스텀_구분자_미사용(){
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });

        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });

        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("1,2:3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

// 아래는 추가된 테스트 케이스
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//|\\n1|2,3:4");
            assertThat(output()).contains("결과 : 10");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//;\\n1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

// 아래는 추가된 테스트 케이스
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;-2;-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2//;\\n3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2, 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1//;\\n2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}