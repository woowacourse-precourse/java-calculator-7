package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CustomTest extends NsTest {

    @Test
    void 커스텀_구분자_및_공백_처리() {
        assertSimpleTest(() -> {
            run("//; \\n1 ; 22342 ; 3 ");
            assertThat(output()).contains("결과 : 22346");
        });
    }

    @Test
    void 연속된_구분자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_값_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void null_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException((String) null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_처리() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_순서_바뀜_예외처리() {
        // 커스텀 구분자 선언이 잘못된 경우, 예를 들어 \n이 먼저 온 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n//1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사이에_숫자_예외처리() {
        // 커스텀 구분자 위치에 숫자가 있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_숫자로_지정() {
        // 커스텀 구분자로 숫자를 사용한 경우 예외 없이 처리
        assertSimpleTest(() -> {
            run("//1\\n11231");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
