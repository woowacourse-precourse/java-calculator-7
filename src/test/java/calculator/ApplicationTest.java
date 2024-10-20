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
    void 커스텀_구분자_중복_등록() {
        assertSimpleTest(() -> {
            run("//;;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_여러개_등록() {
        assertSimpleTest(() -> {
            run("//;-\\n1-2;3:4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_등록_생략() {
        assertSimpleTest(() -> {
            run("//\\n1,3,4:10");
            assertThat(output()).contains("결과 : 18");
        });
    }

    @Test
    void 커스텀_등록_문자열_시작_위치_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3//:\\n3:2,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
