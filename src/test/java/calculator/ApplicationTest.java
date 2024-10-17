package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\n1");
//            assertThat(output()).contains("결과 : 1");
//            System.out.println(output());
//        });
//    }

    @Test
    void 정수_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
            System.out.println(output());
        });
    }

    @Test
    void 음수_사용() {
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("4");
            System.out.println(output());
        });
    }

    @Test
    void 실수_사용() {
        assertSimpleTest(() -> {
            run("1.1,2,3");
            assertThat(output()).contains("결과 : 6.1");
            System.out.println(output());
        });
    }


    @Test
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            run(",1   1");
            assertThat(output()).contains("11");
            System.out.println(output());
        });
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            run("1 , 1, 1  1");
            assertThat(output()).contains("14");
            System.out.println(output());
        });
    }
//
//    @Test
//    void 예외_테스트3() {
//        assertSimpleTest(() -> {
//            run("");
//            assertThat(output()).contains("");
//            System.out.println(output());
//        });
//    }
//
//
//    @Test
//    void 예외_테스트4() {
//        assertSimpleTest(() -> {
//            run("");
//            assertThat(output()).contains("");
//            System.out.println(output());
//        });
//    }
//
//
//    @Test
//    void 예외_테스트5() {
//        assertSimpleTest(() -> {
//            run("");
//            assertThat(output()).contains("");
//            System.out.println(output());
//        });
//    }
//
//
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("-1,2,3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}