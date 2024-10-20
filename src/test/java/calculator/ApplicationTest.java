package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ApplicationTest extends NsTest {

    @Test
    void 성공_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2;3,4:5");
            assertThat(output()).contains("결과 : 15");
        });

        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() -> {
            run("-1,2,3"); // 예외를 유발하는 입력을 전달
            assertThat(output()).contains("음수는 허용되지 않습니다.");
        });
    }

    @Test
    void 문자_입력_예외() {
        assertSimpleTest(() -> {
            run("1,a,2"); // 문자가 포함된 입력
            assertThat(output()).contains("숫자가 아닌 다른 문자가 입력되었습니다.");
        });
    }

    @Test
    void 커스텀_구분자_없음_예외() {
        assertSimpleTest(() -> {
            run("//;1;2"); // \n이 없는 경우
            assertThat(output()).contains("\\n이 없습니다.");
        });
    }

    @Test
    void 커스텀_구분자_중복_예외() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;;3"); // 구분자가 중복된 경우
            assertThat(output()).contains("구분자 뒤에는 숫자가 와야합니다.");
        });
    }

    @Test
    void 구분자_뒤에_숫자_없음_예외() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;"); // 구분자 뒤에 숫자가 없는 경우
            assertThat(output()).contains("구분자 뒤에는 숫자가 와야합니다.");
        });
    }

    @Test
    void 커스텀_구분자_중복_사용_예외() {
        assertSimpleTest(() -> {
            run("//;\\n//^\\n1;2^3"); // 커스텀 구분자 여러 개 사용
            assertThat(output()).contains("커스텀 구분자는 하나만 입력할 수 있습니다.");
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자_동일_예외() {
        assertSimpleTest(() -> {
            run("//:\\n1,2,3"); // 기본 구분자와 커스텀 구분자가 동일한 경우
            assertThat(output()).contains("커스텀 구분자와 기본 구분자는 동일할 수 없습니다.");
        });
    }

    @Test
    void 숫자_너무_큼_예외() {
        assertSimpleTest(() -> {
            run("//;\\n2147483648;1"); // int 범위를 초과한 숫자
            assertThat(output()).contains("숫자가 너무 큽니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
