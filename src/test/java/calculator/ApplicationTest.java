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
    void 구분자_연속_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;;;;;3;;4;5;");
            assertThat(output()).contains("결과 : 13");
        });
    }
    @Test
    void 마이너스구분자_사용(){
        assertSimpleTest(() -> {
            run("//-\\n-1-2-3--4-5--");
            assertThat(output()).contains("결과 : 15");
        });
    }
    @Test
    void 기본구분자_커스텀구분자_같이_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2,3;4;;5;:6");
            assertThat(output()).contains("결과 : 21");
        });
    }
    @Test
    void 공백_문자만(){
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자사이공백_문자(){
        assertSimpleTest(() -> {
            run("1,2    ,3,4 ");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 여러자리숫자(){
        assertSimpleTest(() -> {
            run("1234,1,2,3");
            assertThat(output()).contains("결과 : 1240");
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
    void 숫자초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
