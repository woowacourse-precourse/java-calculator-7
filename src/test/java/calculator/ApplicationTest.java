package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
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
    void 다양한_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_및_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 길이가_2개_이상인_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//**\\n1**2**3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 잘못된_커스텀_구분자_생성() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2"))
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
    void 미존재_구분자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_미존재() {
        assertSimpleTest(() -> {
            run(",,:");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 값이_NULL일때() {
        assertSimpleTest(() -> {
            assertThat(Application.isEmptyInput(null) == true);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
