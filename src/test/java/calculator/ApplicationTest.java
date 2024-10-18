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
    void 예외_테스트_255자_이상() {
        //Todo: 길이가 225이상인 문자열을 입력했을 경우 예외
    }

    @Test
    void 예외_테스트_커스텀_구분자를_가진_문자열을_위한_최소길이_미충족() {
        //Todo: "//"로 시작하는 문자열 중에서 길이가 5 이하인 문자열일 경우 예외처리

    }

    @Test
    void 예외_테스트_커스텀_구분자를_가진_문자열_올바르지않은_형식(){
        //Todo: "//"로 시작하는 문자열이 "//<구분자>\n" 형식이 아니면 예외처리
    }

    @Test
    void 예외_테스트_커스텀_구분자가_숫자일_경우(){
        //Todo: 커스텀 구분자가 숫자일 경우 예외처리
    }

    @Test
    void 예외_테스트_덧셈_결과값이_10억_이상일_경우(){
        //Todo: 덧셈 결과값이 10억 이상일 경우 예외처리
    }

    @Test
    void 예외_테스트_입력한_숫자가_10억_이상일_경우(){
        //Todo: 입력한 숫자가 10억 이상일 경우 예외처리
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
