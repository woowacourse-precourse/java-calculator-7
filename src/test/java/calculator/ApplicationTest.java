//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calculator;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    ApplicationTest() {
    }

    @Test
    void 커스텀_구분자_사용() {
        Assertions.assertSimpleTest(() -> {
            this.run(new String[]{"//;\\n1"});
            org.assertj.core.api.Assertions.assertThat(this.output()).contains(new CharSequence[]{"결과 : 1"});
        });
    }

    @Test
    void 예외_테스트() {
        Assertions.assertSimpleTest(() -> {
            org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
                this.runException(new String[]{"-1,2,3"});
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈_문자열_처리() {
        Assertions.assertSimpleTest(() -> {
            this.run(new String[]{"\n"});
            org.assertj.core.api.Assertions.assertThat(this.output()).contains(new CharSequence[]{"결과 : 0"});
        });
    }

    @Test
    void 기본_구분자_쉼표_콜론_사용() {
        Assertions.assertSimpleTest(() -> {
            this.run(new String[]{"1,2,3"});
            org.assertj.core.api.Assertions.assertThat(this.output()).contains(new CharSequence[]{"결과 : 6"});
        });
        Assertions.assertSimpleTest(() -> {
            this.run(new String[]{"1:2:3"});
            org.assertj.core.api.Assertions.assertThat(this.output()).contains(new CharSequence[]{"결과 : 6"});
        });
        Assertions.assertSimpleTest(() -> {
            this.run(new String[]{"1,2:3"});
            org.assertj.core.api.Assertions.assertThat(this.output()).contains(new CharSequence[]{"결과 : 6"});
        });
    }

    @Test
    void 음수_입력시_예외처리() {
        Assertions.assertSimpleTest(() -> {
            ((AbstractThrowableAssert)org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
                this.runException(new String[]{"1,-2,3"});
            }).isInstanceOf(IllegalArgumentException.class)).hasMessageContaining("음수는 허용되지 않습니다: -2");
        });
    }

    @Test
    void 유효하지_않은_숫자_입력_예외처리() {
        Assertions.assertSimpleTest(() -> {
            ((AbstractThrowableAssert)org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
                this.runException(new String[]{"1,a,3"});
            }).isInstanceOf(IllegalArgumentException.class)).hasMessageContaining("유효한 숫자가 아닙니다: a");
        });
    }

    @Test
    void 빈_값이_있을_때_예외처리() {
        Assertions.assertSimpleTest(() -> {
            ((AbstractThrowableAssert)org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
                this.runException(new String[]{"1, ,2"});
            }).isInstanceOf(IllegalArgumentException.class)).hasMessageContaining("유효한 숫자가 아닙니다: 빈 문자열");
        });
    }

    public void runMain() {
        Application.main(new String[0]);
    }
}