package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    // [쉼표와 콜론만을 구분자로 가지는 문자열의 합 계산] 구현 후 통과해야하는 test
    @Test
    void 숫자_한_개_테스트() {
        // 기본
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 빈_문자열_테스트() {
        // 빈문자열
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_여러_개_테스트1() {
        // 정상값 입력
        assertSimpleTest(() -> {
            run("1:3,2");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_여러_개_테스트2() {
        assertSimpleTest(() -> {
            run("1:3,2,40,800,29");
            assertThat(output()).contains("결과 : 875");
        });
    }


    // [쉼표와 콜론만을 구분자로 가지는 문자열의 예외 처리] 구현 후 통과해야하는 test
    @Test
    void 앞에_수_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 뒤에_수_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자가_연속해서_나오는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_들어온_경우1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_들어온_경우2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,231,5=73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,231,5a73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,231,5.73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woowa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2o3w4a5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력4() {
        // 입력으로 0이 들어오는 경우 1
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력5() {
        // 입력으로 0이 들어오는 경우 2
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [커스텀 구분자를 추가한 문자열이 들어오는 경우에 대한 합 계산] 구현 후 통과해야하는 test
    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("// \\n1 2,3:4 5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//a\\n1a2,3:4a5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용_및_빈문자열() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_숫자인_경우1() {
        assertSimpleTest(() -> {
            run("//3\\n13234");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자_숫자인_경우2() {
        assertSimpleTest(() -> {
            run("//0\\n102,4:508");
            assertThat(output()).contains("결과 : 20");
        });
    }


    // [커스텀 구분자를 추가한 경우에 대한 예외 처리] 구현 후 통과해야하는 test
    @Test
    void 잘못된_형식1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식2() {
        // 구분자로 문자열이 들어온 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\n1:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식4() {
        // 구분자가 없는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//s\\m1:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_앞에_수_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[\\n[2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_뒤에_수_없는_경우1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//=\\n1,2="))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_뒤에_수_없는_경우2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0\\n1020"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구분자가_연속해서_나오는_경우1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n1223"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구분자가_연속해서_나오는_경우2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;;3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구분자만_들어온_경우1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구분자만_들어온_경우2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구분자만_들어온_경우3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_구분자1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\1,231,5=73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_구분자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\1,231,5a73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_구분자3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,231,5.73:231"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_입력1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_입력2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//w\\nwoowa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_입력3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\n1:2o3w4a5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_입력4() {
        // 커스텀 구분자가 있고 입력으로 0이 들어오는 경우 1
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\n0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_잘못된_입력5() {
        // 커스텀 구분자가 있고 입력으로 0이 들어오는 경우 2
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\1,0"))
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
