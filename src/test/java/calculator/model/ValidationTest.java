package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest extends NsTest {

    @Test
    public void 커스텀구분자_선언된_경우_1() {
        String input = "//;\\n1;2;3";
        assertSimpleTest(() -> {
            Calculator calculator = new Calculator();
            Assertions.assertEquals(6, calculator.add(input));
        });
    }

    @Test
    public void 커스텀구분자_선언된_경우_2() {
        String input = "//a\\n1a2a3";
        assertSimpleTest(() -> {
            Calculator calculator = new Calculator();
            Assertions.assertEquals(6, calculator.add(input));
        });
    }

    @Test
    public void 입력_값에_음수가_포함된_경우_1() {
        String input = "1,2,3,-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 입력_값에_음수가_포함된_경우_2() {
        String input = "-1,-2,3,-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 입력_값에_알파벳이_포함된_경우() {
        String input = "1,a,b,4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 입력_값에_특수문자_포함된_경우() {
        String input = "&,2,3,4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 기본_구분자_이외의_문자_포함된_경우_1(){
        String input = "1,2,3?-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 기본_구분자_이외의_문자_포함된_경우_2(){
        String input = "!!!1,2,3?-4";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 커스텀_지정자가_올바르지_않은_경우_1(){
        String input = "//;n1;2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 커스텀_지정자가_올바르지_않은_경우_2(){
        String input = "//;1\n1.2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 커스텀_지정자가_올바르지_않은_경우_3(){
        String input = "//--\\n1+2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 커스텀_지정자가_없고_지정된_구분자_이외_문자가_포함된_경우_1(){
        String input = "1=2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 커스텀_지정자가_없고_지정된_구분자_이외_문자가_포함된_경우_2(){
        String input = ";\n1;2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    public void 커스텀_지정자가_없고_지정된_구분자_이외_문자가_포함된_경우_3(){
        String input = ";\n1;2;3";
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new Calculator().add(input))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
