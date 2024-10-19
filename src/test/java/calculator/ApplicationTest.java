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
    void 커스텀_구분자_여러_문자_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3://!a@b#c\\n4!a@b#c5!a@b#c6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 두자리_이상_양수_테스트() {
        assertSimpleTest(() -> {
            run("1,12:3://*\\n4*50*6*30");
            assertThat(output()).contains("결과 : 106");
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
    void 커스텀_구분자_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3//\n456"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_슬래쉬_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3////\n456"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_양수_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3//4;\n4;56"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_선언전_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3//;\n4;56"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}