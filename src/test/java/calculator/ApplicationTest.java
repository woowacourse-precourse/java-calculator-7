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
    void 두자리수_이상_문자_덧셈(){
        assertSimpleTest(() -> {
            run("1,11,111,1111,11111,111111,1111111,11111111,111111111,876543211");
            assertThat(output()).contains("결과 : 1000000000");
        });
    }

    @Test
    void 커스텀_구분자가_두글자(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;,\\n1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 커스텀_구분자가_없음(){
        assertSimpleTest(() -> {
            run("//\\n1:12");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 엄청_큰_결과값(){
        assertSimpleTest(() -> {
            run("1000000000000000:1000000000000000");
            assertThat(output()).contains("결과 : 2000000000000000");
        });
    }

    @Test
    void 정의되지않은_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2-3,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_테스트() {
        assertSimpleTest(() -> {
            run("//-\\n1,1:1-1");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 숫자_구분자_정상연산시() {
        assertSimpleTest(() -> {
            run("//1\\n212");
            assertThat(output()).contains("결과 : 4");
        });
    }
    
    @Test
    void 숫자_구분자_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }





    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
