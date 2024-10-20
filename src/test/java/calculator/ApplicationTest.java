package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 입력_메세지_출력_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
        });
    }

    @Test
    void 입력_정상_처리_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 문자_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,a:3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 특수_문자_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,@:3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자_패턴_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1,2!3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 빈_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("// \\n1 2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 줄바꿈_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//\\n\\n1\\n2\\n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러_줄바꿈_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//\\n\\n\\n\\n1\\n\\n\\n2\\n\\n\\n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 긴_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//@$@#DR%GG#W$U^SZTGFHDTSR^T#AWZDHS%ETRAW#@\\n1@$@#DR%GG#W$U^SZTGFHDTSR^T#AWZDHS%ETRAW#@2@$@#DR%GG#W$U^SZTGFHDTSR^T#AWZDHS%ETRAW#@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 매우_큰_정수_처리_테스트() {
        assertSimpleTest(() -> {
            run("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,1");
            assertThat(output()).contains(
                    "결과 : 1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        });
    }

    @Test
    void 매우_긴_소수_처리_테스트() {
        assertSimpleTest(() -> {
            run("0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002");
            assertThat(output()).contains(
                    "결과 : 0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
