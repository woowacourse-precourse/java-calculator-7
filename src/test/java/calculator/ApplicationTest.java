package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;1;;");
            assertThat(output()).contains("결과 : 2");
        });
    }
    @Test
    void 잘못된_커스텀_구분자() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            run("//;\\n1;1;abc"); // 잘못된 입력 실행
        });

        // 예외 메시지 확인
        assertEquals("잘못된 형식의 입력입니다.", exception.getMessage());
    }
    @Test
    void 이중_커스텀_구분자() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            run("//;\\n1;1;//,\n11;"); // 잘못된 입력 실행
        });

        // 예외 메시지 확인
        assertEquals("잘못된 형식의 입력입니다.", exception.getMessage());
    }
    @Test
    void 숫자만_들어갔을_때() {
        assertSimpleTest(() -> {
            run("11");
            assertThat(output()).contains("결과 : 11");
        });
    }
    @Test
    void 기본_구분자_중_다른_문자_에러() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            run("//1,1;"); // 잘못된 입력 실행
        });

        // 예외 메시지 확인
        assertEquals("기본 구분자가 아닌 문자가 포함되었습니다.", exception.getMessage());
    }
    @Test
    void 커스텀_구분자_문자열() {
        assertSimpleTest(() -> {
            run("//mn\\n1mn1mn1mn");
            assertThat(output()).contains("결과 : 3");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
