package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 빈 문자열 입력 시 결과는 0
/*    @Test  
    void 빈_문자열_사용() {   //Console.readLine(); 사용으로 불가 ??
        assertSimpleTest(() -> {
            run(""); // 빈 문자열
            assertThat(output()).contains("결과 : 0");
        });
    }*/
    @Test
    void 단일_숫자_입력_사용() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }
    // 기본 구분자 사용: 쉼표, 콜론
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    // 커스텀 구분자 사용 시 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 음수 입력 시 예외 발생 및 메시지 검증
    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}