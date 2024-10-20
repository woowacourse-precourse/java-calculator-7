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
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자() {
        assertSimpleTest(()->{
            run("//@\\n1@2@3");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 기본_커스텀_구분자_혼합() {
        assertSimpleTest(()->{
            run("//@\\n1@2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 모르는_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_대신_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자만_존재(){
        assertSimpleTest(()->{
            run("1234");
            assertThat(output()).contains("결과 : 1234");
        });
    }

    @Test
    void 커스텀_구분자가_기본_구분자(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("//,\\n1,2,3,4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
