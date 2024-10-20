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
    void 숫자가_없는_경우() {
        Calculator calculator = new Calculator(",,:");
        assertThatThrownBy(calculator::add)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 없습니다.");
    }

    @Test
    void 소수점_위치가_이상한_경우() {
        Calculator calculator = new Calculator("1.2.3,4");
        assertThatThrownBy(calculator::add)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 소수점 형식입니다.");
    }

    @Test
    void 실수를_계산하는_경우() {
        Calculator calculator = new Calculator("1.2,3.5");
        assertThat(calculator.add()).isEqualTo("결과 : 4.7");
    }

    @Test
    void 기본_구분자_외에_다른_문자가_있는_경우() {
        Calculator calculator = new Calculator("1,2:3|4");
        assertThatThrownBy(calculator::add)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값에 문자가 있습니다.");
    }

    @Test
    void 빈_문자열_입력한_경우() {
        Calculator calculator = new Calculator("");
        assertThat(calculator.add()).isEqualTo("결과 : 0");
    }

    @Test
    void 문자열이_null인_경우() {
        Calculator calculator = new Calculator(null);
        assertThat(calculator.add()).isEqualTo("결과 : 0");
    }

    @Test
    void 구분자_없이_숫자만_있는_경우() {
        Calculator calculator = new Calculator("123");
        assertThat(calculator.add()).isEqualTo("결과 : 123");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
        }
    }