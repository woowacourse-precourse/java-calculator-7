package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void Null_또는_빈문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("", null))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자가_하나인_경우() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 쉼표_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콜론_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 쉼표_콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 단일_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자에_대괄호_사용() {
        assertSimpleTest(() -> {
            run("//[\\n1[2[3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자에_빈문자_사용() {
        assertSimpleTest(() -> {
            run("//\\n123");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자에_문자_사용() {
        assertSimpleTest(() -> {
            run("//abc\\n1abc2abc3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_잘못된_위치() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정의되지_않은_커스텀_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3"))
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
