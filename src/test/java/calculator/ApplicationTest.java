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
    void 공백_입력_테스트() {
        assertSimpleTest(() -> {
            run("\t");
            assertThat(output()).contains("결과 : 0");
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
    void 예외_테스트_주어진_구분자가_아니지만_입력_받은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2*3,4@5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_쌍따옴표인_경우() {
        String delim = "\"";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_따옴표인_경우() {
        String delim = "\'";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_괄호인_경우1() {
        String delim = "(";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_괄호인_경우2() {
        String delim = ")";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_대괄호인_경우1() {
        String delim = "[";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_대괄호인_경우2() {
        String delim = "]";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_중괄호인_경우1() {
        String delim = "{";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_중괄호인_경우2() {
        String delim = "}";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_물음표인_경우() {
        String delim = "?";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_별표인_경우() {
        String delim = "*";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_특수문자인_백슬래쉬인_경우() {
        String delim = "|";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_구분자가_백슬래쉬_특수문자_패턴인_경우() {
        String delim = "\\|";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_1() {
        String delim = "\\\\\\\\?";
        assertSimpleTest(() -> {
            run("//" + delim + "\\n1" + delim + "2" + delim + "3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
