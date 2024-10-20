package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 널_문자열_사용() {
        assertSimpleTest(() -> {
            long result = Application.calculate(null); // null 입력
            System.out.println("널 문자열 입력 시 결과: " + result); // 결과 출력
            assertThat(result).isEqualTo(0); // 결과는 0
        });
    }

    // 빈 문자열 입력 시 결과는 0
    @Test
    void 빈_문자열_사용() {
        assertSimpleTest(() -> {
            long result = Application.calculate(""); // 빈 문자열
            System.out.println("빈 문자열 입력 시 결과: " + result); // 결과 출력
            assertThat(result).isEqualTo(0); // 결과는 0
        });
    }

    @Test
    void 단일_숫자_입력_사용() {
        assertSimpleTest(() -> {
            long result = Application.calculate("5");
            System.out.println("단일 숫자 입력 시 결과: " + result); // 결과 출력
            assertThat(result).isEqualTo(5); //결과는 5
        });
    }

    // 기본 구분자 사용: 쉼표, 콜론
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            long result = Application.calculate("1,2:3");
            System.out.println("기본 구분자 사용 시 결과: " + result); // 결과 출력
            assertThat(result).isEqualTo(6); // 결과는 6
        });
    }

    // 커스텀 구분자 사용 시 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            long result = Application.calculate("//;\n1;2;3");
            System.out.println("커스텀 구분자 사용 시 결과: " + result); // 결과 출력
            assertThat(result).isEqualTo(6); // 결과는 6
        });
    }

    // 음수 입력 시 예외 발생 및 메시지 검증
    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.calculate("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{}); // 메인 메서드 호출
    }
}
