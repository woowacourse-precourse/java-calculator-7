package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_와_기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자_가_처음_또는_끝에_위치한_경우() {
        assertSimpleTest(() -> {
            run(",1:2,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 입력이_주어지지_않은_경우() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void null_이_커스텀_구분자인_경우() {
        assertSimpleTest(() -> {
            run("//null\\n1null2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 슬래시가_커스텀_구분자인_경우() {
        assertSimpleTest(() -> {
            run("////\\n1//2,3:4");
            assertThat(output()).contains("결과 : 10");
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
    void 예외_테스트_지정된_구분자가_아닌_다른_문자_가_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트_지정된_구분자가_아닌_다른_문자_가_입력_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,/3:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트_지정된_구분자가_아닌_다른_문자_가_입력_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,English3:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트_지정된_구분자가_아닌_다른_문자_가_입력_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,한글3:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트_null_입력_구분자_사이에_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,null:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트_null_입력_구분자_위치에_들어간_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3null4:5"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 개행_문자가_커스텀_구분자인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n\\n1//2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
