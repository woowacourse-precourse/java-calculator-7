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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_있는_경우_이를_제거하여_반환하는_테스트() {
       String inputStr = "//+\n12,3+4:5";
       InputStringProcessor inputStringProcessor = new InputStringProcessor();
       String slicedInputStr = inputStringProcessor.removeFirstFiveCharacters(inputStr);
       assertThat(slicedInputStr).isEqualTo("12,3+4:5");
    }

    @Test
    void 문자열의_첫5글자를_반환하는_테스트() {
        String inputStr = "//+\n12,3+4:5";
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        String slicedInputStr = inputStringProcessor.getFirstFiveCharacters(inputStr);
        assertThat(slicedInputStr).isEqualTo("//+\n");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
