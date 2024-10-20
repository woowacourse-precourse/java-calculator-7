package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 기본_테스트() {
        assertSimpleTest(() ->
                run(""));
        assertThat(output()).contains("결과 : 0");
        assertSimpleTest(() ->
                run("1,2"));
        assertThat(output()).contains("결과 : 3");
        assertSimpleTest(() ->
                run("1,2,3"));
        assertThat(output()).contains("결과 : 6");
        assertSimpleTest(() ->
                run("1,2:3"));
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void 특수문자_테스트() {
        String input1 = "//+\\n1+2+3+4+5+6+7+8+9+10";
        assertSimpleTest(() ->
                run(input1));
        assertThat(output()).contains("결과 : 55");
        String input2 = "//+\\n10+20+30+40";
        assertSimpleTest(() ->
                run(input2));
        assertThat(output()).contains("결과 : 100");
    }

    @Test
    void 섞어_사용하기() {
        String input1 = "//+\\n1,2:3+4:5:6,7+8:9,10";
        assertSimpleTest(() ->
                run(input1));
        assertThat(output()).contains("결과 : 55");
        String input2 = "//+\\n10,20+30:40";
        assertSimpleTest(() ->
                run(input2));
        assertThat(output()).contains("결과 : 100");
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자와_일반_구분자_같이_쓰기() {
        assertSimpleTest(() -> {
            run("//@\\n10@100@1000:1000");
            assertThat(output()).contains("결과 : 2110");
        });
    }

    @Test
    void 여러자리수_입력() {
        assertSimpleTest(() -> {
            run("//;\\n10;100;1000");
            assertThat(output()).contains("결과 : 1110");
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
    void 구분자로만_구성된_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 수가_다_입력되지_않은_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10,,10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자로만_구성된_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;;;;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이상한_커스텀_선언() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;?n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀와_모든_수가_입력되지_않은_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;;;10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:?:10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_음수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;?;10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
