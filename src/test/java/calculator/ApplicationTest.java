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
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 커스텀_구분자() {
        assertSimpleTest(()->{
            run("//^\\n1^3^3");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자2() {
        assertSimpleTest(()->{
            run("//&\\n1&2&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_띄어쓰기() {
        assertSimpleTest(()->{
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_2글자() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2;;3");
            assertThat(output()).contains("결과 : 6");
                         }
        );
    }

    @Test
    void 커스텀_구분자_5글자(){
        assertSimpleTest(()->{
            run("//;;;;;\\n1;;;;;2;;;;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 알려주지_않은_커스텀_구분자() {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("1;4,2:3"))
             .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자대신문자() {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("a,1,2"))
             .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자없이(){
        assertSimpleTest(()->{
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 예외테스트_커스텀구분자_여러번(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("//;\\n//#\\n1;2;3;4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 예외테스트_커스텀구분자가_기본구분자일때(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("//,\\n1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void n_구분자_테스트(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("//^\\1^2^3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
