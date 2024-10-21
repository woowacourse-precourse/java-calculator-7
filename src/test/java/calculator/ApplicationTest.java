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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /*
    기본 테스트 이외에 추가로 테스트 케이스 추가
    */

    //숫자가 아닌 문자가 포함된 경우
    @Test
    void 숫자가_아닌_문자가_포함된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //구분자가 ,일 경우
    @Test
    void 구분자가_콤마일_경우() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    //커스텀 구분자가 포함된 경우
    @Test
    void 커스텀_구분자가_포함된_경우() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    //커스텀 구분자가 숫자일 경우
    @Test
    void 커스텀_구분자가_숫자일_경우() {
        assertSimpleTest(() -> {
            run("//2\\n123");
            assertThat(output()).contains("결과 : 4");
        });
    }

    //커스텀 구분자와 음수가 포함될 경우
    @Test
    void 커스텀_구분자와_음수가_포함될_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //커스텀 구분자가 올바르게 지정되지 않았을 경우
    @Test
    void 커스텀_구분자가_올바르게_지정되지_않았을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
