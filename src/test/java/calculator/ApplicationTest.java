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

    }


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("//;\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });

        assertSimpleTest(() -> {
            run("//\n\n1\n23\n5");
            assertThat(output()).contains("결과 : 29");
        });
    }

    @Test
    void 입력값이_없을_때() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자가_숫자() {
        assertSimpleTest(() -> {
            run("//22\n122322");
            assertThat(output()).contains("결과 : 4");
        });

        assertSimpleTest(() -> {
            run("//22\n222");
            assertThat(output()).contains("결과 : 2");
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
                assertThatThrownBy(() -> runException("@//*\n1*33*1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void checkType_null_입력_테스트(){
//        //given
//        Calculator calculator = new Calculator();
//
//        //when&then
//        assertSimpleTest(() -> {
//            calculator.checkType(null);
//            assertThat(output()).contains("결과 : 0");
//        });
//
//    }

    
//    @Test
//    void isPositiveNum_예외_테스트(){
//        //given
//        Calculator calculator = new Calculator();
//        String toBeChecked = "-1";
//
//        //when & then
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> calculator.isPositiveNum(toBeChecked))
//                        .isInstanceOf(IllegalArgumentException.class));
//    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}




