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
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:3,6");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 공백_문자_입력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 등록하지_않은_구분자_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1:2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_2개_사용() {
        assertSimpleTest(() ->{
            run("1//{\\n3{2//#\\n5#6");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 커스텀_구분자_연속_등록() {
        assertSimpleTest(() ->{
            run("1//{\\n//#\\n5");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
