package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run(",:");
            assertThat(output()).contains("결과 : 0");
        });

        assertSimpleTest(() -> {
            run(":1:2,3");
            assertThat(output()).contains("결과 : 0");
        });

    }


    @Test
    void 입력값이_없을_때() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void isPositiveNum_예외_테스트(){
        //given
        String toBeChecked = "-1";

        //when & then
        assertThatThrownBy(() -> CheckIsPositiveNum.isPositiveNum(toBeChecked))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });

        assertSimpleTest(() -> {
            run("//\\n1235");
            assertThat(output()).contains("결과 : 11");
        });

        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });

        // 커스텀 구분자로 시작할 때
        assertSimpleTest(() -> {
            run("//;\\n;2");
            assertThat(output()).contains("결과 : 2");
        });

        // |라는 문자가 포함되었을 때
        assertSimpleTest(() -> {
            run("//|\\n|2|3");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("//||\\n||2||3");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("//-\\n2--22");
            assertThat(output()).contains("결과 : 24");
        });

        // 구분자가 공백일 경우 1: " "
        assertSimpleTest(() -> {
            run("// \\n2 22");
            assertThat(output()).contains("결과 : 24");
        });

        // 구분자가 공백일 경우 2: "  "
        assertSimpleTest(() -> {
            run("//  \\n2  22");
            assertThat(output()).contains("결과 : 24");
        });

    }


    @Test
    void 커스텀_구분자가_숫자() {
        assertSimpleTest(() -> {
            run("//22\\n122322");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//22\\n222");
            assertThat(output()).contains("결과 : 2");
        });

        assertSimpleTest(() -> {
            run("//0\\n2022");
            assertThat(output()).contains("결과 : 24");
        });

        assertSimpleTest(() -> {
            run("//00\\n00");
            assertThat(output()).contains("결과 : 0");
        });

    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2?3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("@//*\\n1*33*1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*\\n1*-1*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//00\\n1002000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//||\\n||2||3|"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//  \\n2  3 4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
