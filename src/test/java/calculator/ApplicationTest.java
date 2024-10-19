package calculator;

import calculator.checkMethod.CheckIsPositiveNum;
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
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("12");
            assertThat(output()).contains("결과 : 12");
        });

        assertSimpleTest(() -> {
            run("10");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Test
    void 입력값이_없는_경우() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 피연산자가_소수인_경우() {
        assertSimpleTest(() -> {
            run("1.1");
            assertThat(output()).contains("결과 : 1.1");
        });

        assertSimpleTest(() -> {
            run("1.1,2.2");
            assertThat(output()).contains("결과 : 3.3");
        });

        assertSimpleTest(() -> {
            run("1.0,1");
            assertThat(output()).contains("결과 : 2");
        });
    }


    @Test
    void isPositiveNum_예외테스트(){
        //given
        String toBeChecked = "-1";

        //when & then
        assertThatThrownBy(() -> CheckIsPositiveNum.isPositiveNum(toBeChecked))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

        // 커스텀 구분자와 기본 구분자 둘 다 사용되는 경우
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });

        // 커스텀 기본자 입력값이 없는 경우(""일 경우)
        assertSimpleTest(() -> {
            run("//\\n1234");
            assertThat(output()).contains("결과 : 10");
        });

        // 커스텀 구분자 지정 이후 아무 값도 없을 경우
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });

        // 커스텀 구분자로 시작하는 경우
        assertSimpleTest(() -> {
            run("//;\\n;2");
            assertThat(output()).contains("결과 : 2");
        });

        // |가 포함된 경우
        assertSimpleTest(() -> {
            run("//|\\n|2|3");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("//||\\n||2||3");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("//\\|\\n2\\|3");
            assertThat(output()).contains("결과 : 5");
        });

        assertSimpleTest(() -> {
            run("//-\\n2--22");
            assertThat(output()).contains("결과 : 24");
        });

        // 커스텀 구분자가 길이가 1인 공백일 경우
        assertSimpleTest(() -> {
            run("// \\n2 22");
            assertThat(output()).contains("결과 : 24");
        });

        // 커스텀 구분자가 길이가 2인 공백일 경우
        assertSimpleTest(() -> {
            run("//  \\n2  22");
            assertThat(output()).contains("결과 : 24");
        });

        // 기본 구분자가 커스텀 구분자로 입력된 경우
        assertSimpleTest(() -> {
            run("//:\\n2:2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//::\\n2::2:2");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("///\\n2/2");
            assertThat(output()).contains("결과 : 4");
        });

    }


    @Test
    void 구분자가_이스케이프_문자(){
        assertSimpleTest(() -> {
            run("//'\\n2'2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//''\\n2''2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//\"\\n2\"2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//\\\"\\n2\\\"2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//\\t\\n2\\t2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//\\r\\n2\\r2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//\\r2\\n2\\r22");
            assertThat(output()).contains("결과 : 4");
        });
    }


    @Test
    void 구분자가_정규표현식(){
        assertSimpleTest(() -> {
            run("//\\.\\n2\\.2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//?\\n2?2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//{\\n2{2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//*\\n2*2");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//[\\n2[2");
            assertThat(output()).contains("결과 : 4");
        });
    }


    @Test
    void 구분자_숫자() {
        assertSimpleTest(() -> {
            run("//22\\n122322");
            assertThat(output()).contains("결과 : 4");
        });

        // 커스텀 구분자로서의 숫자와 피연산자로서의 숫자를 구분하는지 확인
        assertSimpleTest(() -> {
            run("//22\\n222");
            assertThat(output()).contains("결과 : 2");
        });

        // 양수 아닌 숫자들이 커스텀 연산자일 경우
        assertSimpleTest(() -> {
            run("//0\\n2022");
            assertThat(output()).contains("결과 : 24");
        });

        assertSimpleTest(() -> {
            run("//-1\\n2-122");
            assertThat(output()).contains("결과 : 24");
        });

        assertSimpleTest(() -> {
            run("//00\\n00");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 구분자가_온점(){
        assertSimpleTest(() -> {
            run("//.\\n1.1:2.2");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//..\\n1.1:2.2");
            assertThat(output()).contains("결과 : 3.3");
        });

        // 구분자가 온점보다 우선한다
        assertSimpleTest(() -> {
            run("//.\\n1.1");
            assertThat(output()).contains("결과 : 2");
        });

        assertSimpleTest(() -> {
            run("//..\\n2..2.2");
            assertThat(output()).contains("결과 : 4.2");
        });
    }


    @Test
    void 기본연산자_예외_테스트() {

        // 피연산자는 양수만 가능
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 공백은 기본 연산자가 아님
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2?3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }


    @Test
    void 커스텀연산자_예외_테스트(){
        // 커스텀 연산자 생성 규칙에 오류가 있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("@//*\\n1*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/*\\n1*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*\\n1*-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//00\\n1002000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//||\\n2||3|"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//  \\n2  3 4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n2 34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//..\\n2...2.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//.\\n2.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
