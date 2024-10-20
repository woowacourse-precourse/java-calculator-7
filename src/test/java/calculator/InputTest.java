package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {

    @Test
    @DisplayName("기본 구분자 테스트")
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//!\\n3!4!5");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    void 빈_문자열_입력_시_0을_반환() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    @DisplayName("단일 숫자 입력 시 해당 숫자 반환")
    void 단일_숫자_입력_시_해당_숫자_반환() {
        assertSimpleTest(() -> {
            run("4");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    @DisplayName("커스텀 구분자의 - 를 썼을 경우엔 음수라고 판별하지 않음")
    void 커스텀_구분자의_데쉬를_썼을_경우엔_음수라고_판별하지_않음() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
