package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 그냥_기본입출력_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3:4");
            assertThat(output()).contains("결과: 10");
        });
    }
    @Test
    void 그냥_기본입출력_테스트_2() {
        assertSimpleTest(() -> {
            run("1,2,3:4,7:9:5:11:23:44:55:223:435:22:2,3,3");
        });
    }

    @Test
    void 그냥_기본입출력_테스트_3() {
        assertSimpleTest(() -> {
            run("\n");
        });
    }
    @Test
    void 그냥_기본입출력_테스트_4() {
        assertSimpleTest(() -> {
            run("1");
        });
    }
    @Test
    void 커스텀_구분자_사용_단일() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3 4 5 6 7 8 9 10");
            assertThat(output()).contains("결과: 55");
        });
    }

    @Test
    void 커스텀_구분자_사용_단일_2() {
        assertSimpleTest(() -> {
            run("///\\n1/2/3/4/5/6/7/8/9/10/11");
            assertThat(output()).contains("결과: 66");
        });
    }

    @Test
    void 커스텀_구분자_사용_단일_3() {
        assertSimpleTest(() -> {
            run("//n\\n1n2n3n4n5n6n7n8n9n10n11n12");
            assertThat(output()).contains("결과: 78");
        });
    }


    @Test
    void 커스텀_구분자_사용_멀티() {
        assertSimpleTest(() -> {
            run("//%%\\n1%%2%%3%%4%%5");
            assertThat(output()).contains("결과: 15");
        });
    }

    @Test
    void 커스텀_구분자_사용_멀티_2() {
        assertSimpleTest(() -> {
            run("//ㅇㄱㄹㅇ?\\n1ㅇㄱㄹㅇ?2ㅇㄱㄹㅇ?3ㅇㄱㄹㅇ?4ㅇㄱㄹㅇ?5ㅇㄱㄹㅇ?100");
            assertThat(output()).contains("결과: 115");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,-33"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁㅇㄹㅇㅁㄹ,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,ㄴㅇㄹㅎ,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1%2,33"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1+2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1111111"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    void 예외_테스트_커스텀_문자가종료되지않는경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ㄴㅇㄹㅎㄹㅇㄴㅎㄹㅇㅎㄹdafasgf1#2#3#4#-5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자가일치하지않는경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//$$\\n1,2#4%6#4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_음수(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n1#2#3#4#-5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
