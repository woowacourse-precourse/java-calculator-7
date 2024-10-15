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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 정상적인_입력_1(){
        String input = "1,2,3,4";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    public void 정상적인_입력_2(){
        String input = "1;2,3;4";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    public void 입력값_비어있는_경우(){
        String input = "";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    public void 음수가_포함된_경우(){
        String input = "1,2,3,-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 알파벳_포함된_경우(){
        String input = "1,a,b,4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 특수문자_포함된_경우(){
        String input = "&,2,3,4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 지정된구분자외문자_포함된_경우(){
        String input = "1,2,3?-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 커스텀구분자_선언된_경우_1(){
        String input = "//;\n1;2;3";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    public void 커스텀구분자_선언된_경우_2(){
        String input = "//a\n1a2a3";
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    public void 커스텀구분자가_선언되었지만_올바르지_않은_경우_1(){
        String input = "//;n1;2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 커스텀구분자가_선언되었지만_올바르지_않은_경우_2(){
        String input = ";\n1;2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
