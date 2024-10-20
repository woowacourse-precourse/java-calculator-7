package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;



import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_숫자_사용() {
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
    void 빈_문자열일_경우() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 기본_구분자_쉼표_콜론_사용() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");

            run("1,2,3");
            assertThat(output()).contains("결과 : 6");

            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");

            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_구분자만_존재_빈문자열_반환() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 연속된_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n2;21;-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,::"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자로_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void long_범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775807,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구문_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_없이_줄바꿈() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_길이_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1ab2ab3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_외의_값_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
