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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    // 추가 작성 테스트 코드

    // 기본 구분자를 사용한 테스트
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자를 여러 개 사용한 테스트
    @Test
    void 커스텀_구분자_여러개_사용() {
        assertSimpleTest(() -> {
            run("//;'/dd\\n1;'/dd2;'/dd3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자에 백슬래시가 포함된 경우 테스트
    @Test
    void 커스텀_구분자_백슬래시_사용() {
        assertSimpleTest(() -> {
            run("//\\\\\\n1\\\\2\\\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자에 '[' 또는 ']'가 포함된 경우 테스트
    @Test
    void 커스텀_구분자_특수기호_사용() {
        assertSimpleTest(() -> {
            run("//[]|()?^*+\\n1[]|()?^*+2[]|()?^*+3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 유리수가 포함된 경우 테스트
    @Test
    void 기본_구분자_유리수_사용() {
        assertSimpleTest(() -> {
            run("1.5,3.7,4.3");
            assertThat(output()).contains("결과 : 9.5");
        });
    }

    // 유리수가 포함된 경우 테스트
    @Test
    void 커스텀_구분자_유리수_사용() {
        assertSimpleTest(() -> {
            run("//;'\\n5.5;'3.5;'3");
            assertThat(output()).contains("결과 : 12.0");
        });
    }

    // 구분자 사이에 숫자가 아닌 것이 들어갔을 때 예외 테스트
    @Test
    void 예외_테스트_숫자가_아닌것() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2df,3["))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("구분자 사이에 숫자가 들어있지 않습니다.")
        );
    }

    // 0이 입력됐을 때 테스트
    @Test
    void 예외_테스트_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양수 이외의 값은 입력될 수 없습니다.")
        );
    }

    // 잘못된 형식으로 입력시 테스트
    @Test
    void 예외_테스트_잘못된_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 입력 형식과 일치하지 않습니다.")
        );
    }
}
