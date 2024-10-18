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
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    void 공백_허용(){
        assertSimpleTest(() -> {
            run("1:::2,:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_기본_구분자_혼합_사용(){
        assertSimpleTest(() -> {
            run("//-\\n1:2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_빈_문자_허용(){
        assertSimpleTest(() -> {
            run("// \\n 1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }




    @Test
    void 예외_테스트() { // 0 미허용
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:0:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_2() { // 숫자는 양의 정수만 가능
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_3() { // 커스텀 구분자는 문자열 미허용
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////;\\n1//;2//;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_4() { // 커스텀 구분자는 문자열 미허용
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////;\\n1//;2//;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_5() { // 커스텀 구분자 기준 문자열 사이 아무것도 입력하지 않으면 에러
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
