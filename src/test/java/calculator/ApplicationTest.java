package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ApplicationTest extends NsTest {

    //success
//    @Test
//    void 기본_테스트1() {
//        assertSimpleTest(() -> {
//            run("1:2,3");
//            assertThat(output()).contains("결과 : 6");
//        });
//    }
//
//    @Test
//    void 커스텀_테스트1() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }

//    @Test
//    void 커스텀_테스트3() {
//        assertSimpleTest(() -> {
//            run("//a\\n1a2a3a4");
//            assertThat(output()).contains("결과 : 10");
//        });
//    }

    //fail
//    @Test
//    void 기본_테스트2() {
//        assertSimpleTest(() -> {
//            run("");
//            assertThat(output()).contains("결과 : 0");
//        });
//    }

//    @Test
//    void 기본_예외_테스트1() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("-1,2,3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

//    @Test
//    void 커스텀_예외_테스트1() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("//a\\n1a2a3b4"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
