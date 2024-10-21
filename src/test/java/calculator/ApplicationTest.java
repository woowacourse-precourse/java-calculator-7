package calculator;
import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 커스텀 구분자 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    // 예외 테스트
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            // "-1,2,3" 입력 시 예외가 발생해야 함
            run("-1,2,3");
            assertThat(output()).contains("음수는 허용되지 않습니다");
        });
    }

    // 빈 문자열 테스트
    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            // 아무런 문자열을 입력하지 않고 바로 '엔터' 버튼을 누른 경우이다.
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 큰 숫자 오버플로우 테스트
    @Test
    void 큰_숫자_오버플로우_테스트() {
        assertSimpleTest(() -> {
            run("1000000000,1000000000");
            assertThat(output()).contains("결과 : 2000000000");
        });
    }

    // 기본 구분자 쉼표와 콜론 테스트
    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 잘못된 구분자가 포함된 문자열 예외 처리 테스트
    @Test
    void 잘못된_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,,2"); // 잘못된 구분자가 포함된 경우
            assertThat(output()).contains("잘못된 입력입니다");
        });

        assertSimpleTest(() -> {
            run("1:;2"); // 잘못된 구분자가 포함된 경우
            assertThat(output()).contains("잘못된 입력입니다");
        });
    }

    // 숫자가 아닌 값이 포함된 문자열 예외 처리 테스트
    @Test
    void 숫자가_아닌_값_테스트() {
        assertSimpleTest(() -> {
            run("1,a,3"); // 숫자가 아닌 문자가 포함된 경우
            assertThat(output()).contains("잘못된 입력입니다");
        });

        assertSimpleTest(() -> {
            run("1:2:three"); // 숫자가 아닌 문자가 포함된 경우
            assertThat(output()).contains("잘못된 입력입니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
