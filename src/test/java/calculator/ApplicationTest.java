package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("-1,2,3"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
    private InputValidator inputValidator;
    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }
    @Test
    void 널_문자열_테스트() {
        String nullInput = null;

        assertSimpleTest(() ->
            assertThatThrownBy(() -> inputValidator.validateInput(nullInput))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 문자열_2개이상_테스트() {
        String invalidInput = "\"1,2,3\" \"4,5,6\"";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validateInput(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
