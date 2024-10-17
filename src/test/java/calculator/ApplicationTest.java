package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    // 커스텀 구분자 사용 테스트
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1,3:5,7");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 커스텀_구분자_글자수_2개이상() {
        assertSimpleTest(() -> {
            run("//abc\\n1abc7");
            assertThat(output()).contains("결과 : 8");
        });
    }

    //예외 테스트
    @Test
    void 음수값_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값이 입력 되었습니다.")
        );
    }

    @Test
    void 커스텀_구분자가_공백일때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1abc7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자를 입력 하세요.")
        );
    }

    @Test
    void 수식이_올바르지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",7,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 수식 입니다.")
        );
    }

    @Test
    void 커스텀_문자열이_기존에_있는_구분자와_같은경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,\\n1,7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이미 추가한 구분자는 custom 으로 지정할 수 없습니다.")
        );
    }

    @Test
    void 커스텀_문자열_없이_임의의_값이_추가된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10?7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값이 입력 되었습니다.")
        );
    }

    @Test
    void 커스텀_구분자_생성_포맷이_잘못된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,1,7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자를 추가 하기 위해선 //구분자\\n 형식 으로 입력 하세요.")
        );
    }

    // 메인 실행
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
