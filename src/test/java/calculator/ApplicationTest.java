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

    // 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 이지만,
    // 혹시모를 중간에 들어올 구분자들 체크도 진행.
    @Test
    void 커스텀_구분자_중간에_있으면() {
        assertSimpleTest(() -> {
            run("//;\\n1//+\\n1+3;+1");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 중간에 빈 문자 있으면 문제에따라 문자열에서 숫자를 추출 하는데, 기본 구분자, 커스텀 구분자 외 띄어쓰기 존재하면 예외던져야함.
    @Test
    void 중간에_공백이_있으면_예외던져야함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1; 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    // 문자열 // 열렸으나 \\n 닫힘이 없을시 예외처리,
    @Test
    void 커스텀_구분자_열린후_닫힘_없으면_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1//+\\133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 문자열만 입력시 예외처리.
    @Test
    void 문자열만_입력하였을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("mins-git입니다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 문자가 섞였을때 예외처리
    @Test
    void 문자가_섞였을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("min,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
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
}
