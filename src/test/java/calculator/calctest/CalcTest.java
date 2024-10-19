package calculator.calctest;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcTest extends NsTest {
    @Test
    void 구분자_사용x() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//.\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자는_있지만_특수문자임() {
        Arrays.asList("*", "+", "/", "|", ".", ",", ":", "\\", "/", "?", "{", "}", "[", "]", "$", "^", "(", ")")
                .forEach(delimiter -> {
                    String input = "//" + delimiter + "\\n1" + delimiter + "2" + delimiter + "3";
                    assertSimpleTest(() -> {
                        run(input);  // 해당 입력으로 run 실행
                        assertThat(output()).contains("결과 : 6");  // 1+2+3의 결과가 6이어야 함
                    });
                });
    }

    @Test
    void 커스텀_구분자가_없고_구분자도_적합하지않음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
        //*표 테스트
    void 커스텀문자_예외_테스트(){
        assertSimpleTest(() -> {
            run("//*\\n1,2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자가_구분자인_경우(){
        assertSimpleTest(() -> {
            run("//2\\n12324");
            assertThat(output()).contains("결과 : 8");
        });
    }
    @Test
    void 구분자_시작표시가_없는경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 끝표시가_없는경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백체크() {
        assertSimpleTest(() -> {
            run(",,9,0");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 문자_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("xcv,abc,asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_예외_테스트2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3v,213d,asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_예외_테스트3(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",213d,asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
