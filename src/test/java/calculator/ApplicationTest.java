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
            run("//[+]\\n1+4+5");
            assertThat(output()).contains("결과 : 10");
        });
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
        assertSimpleTest(() -> {
            run("//;\\n5");
            assertThat(output()).contains("결과 : 5");
        });
        assertSimpleTest(() -> {
            run("//;\\n0");
            assertThat(output()).contains("결과 : 0");
        });
        assertSimpleTest(() -> {
            run("//;\\n121");
            assertThat(output()).contains("결과 : 121");
        });
        assertSimpleTest(() -> {
            run("//;;;\\n5;;;3;;;1");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 잘못된_커스텀_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 앞_뒤에_커스텀_구분자가_있으면_안_된다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n;1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//'\n1'"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 앞_뒤에_구분자가_있으면_안_된다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1,2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2,3:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_사이에_공백이_있으면_안_된다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백이면_0이_나온다() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
        assertSimpleTest(() -> {
            run("   ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자로_계산() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
        assertSimpleTest(() -> {
            run("1:1");
            assertThat(output()).contains("결과 : 2");
        });
        assertSimpleTest(() -> {
            run("21");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 숫자만여야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,1,c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수여야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
