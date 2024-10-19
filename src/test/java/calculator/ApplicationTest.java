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
            run("//wfoewjfoiwjfeow\\n1wfoewjfoiwjfeow1");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("30,25,55:90");
            assertThat(output()).contains("결과 : 200");
        });
    }

    @Test
    void 구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("//=\\n30,25=55:90=40:20=40");
            assertThat(output()).contains("결과 : 300");
        });
    }

    @Test
    void 양수가_아닌_예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수가_아닌_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_인척_하는_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ejfi\n2,3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수가_아닌_문자열_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello,im,calculator"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
