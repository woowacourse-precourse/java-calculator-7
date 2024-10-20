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
    void 커스텀_구분자_여러개_지정(){
        run("//;\\n//!\\n1,2;3!4");
        assertThat(output()).contains("결과 : 10");
    }

    @Test
    void 구분자_여러개_지정(){
        run("//;\\n1,2;3");
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void 숫자만_사용(){
        run("123");
        assertThat(output()).contains("결과 : 123");
    }

    @Test
    void 지정되지_않은_구분자_사용(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자없이_구분자_사용(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
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

//    @Test
//    void 입력_테스트(){ //입력이 제대로 받아지는지 테스트
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("입력 문자열 : " + "//;\\n1");
//        });
//    }
//
//    @Test
//    void 숫자_추출_테스트(){ //입력 문자열에서 숫자가 제대로 추출이 되는지 테스트
//        assertSimpleTest(() -> {
//            run("1,2:3,4");
//            assertThat(output()).contains("숫자: [1, 4, 2, 3]");
//        });
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
