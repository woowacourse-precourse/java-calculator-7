package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExtraApplicationTest extends NsTest {
    @Test
    void 디폴트_구분자_사용1() {
        assertSimpleTest(() -> {
            run("2,3,4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 디폴트_구분자_사용2() {
        assertSimpleTest(() -> {
            run("2:3:4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 디폴트_구분자_사용3() {
        assertSimpleTest(() -> {
            run("2,3:4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자와_디폴트_구분자_혼합사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자가_여러_문자일_때() {
        assertSimpleTest(() -> {
            run("//, \\n1, 2, 3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자가_정규식에서_특수문자일_경우() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3*4");
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    void 커스텀_구분자_형식오류1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;2;3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2;3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_지정_안됨() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n2:3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_뒤에_구분자가_올_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자를_제외한_다른_문자가_입력될_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}