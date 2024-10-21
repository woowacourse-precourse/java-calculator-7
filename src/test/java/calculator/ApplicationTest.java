package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 커스텀 구분자를 사용한 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//;\\n//+\\n1+2;3");
            assertThat(output()).contains("결과 : 6");
        });

    }

    // 예외 상황에 대한 테스트
    @Test
    void 예외_테스트() {
        // 음수가 포함된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 잘못된 구분자 형식
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\n2a//4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 구분자가 비어 있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );


        // 숫자와 구분자가 섞여서 잘못된 형식인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2a;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
