package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest extends NsTest {

    @Test
    void 커스텀_구분자를_입력받고_문자열을_입력받는다() {
//        String input = "//;\n1;2;3";
//        UserInput userInput = new UserInput();
//
//        String result = userInput.getInput();
//        System.out.println(result);
//        System.out.println(input);
//        assertThat(result).isEqualTo("1;2;3");  // 입력받은 문자열이 일치하는지 확인
        assertSimpleTest(() -> {
            run("//;\\n1");
            result = output()
            assertThat(output()).contains("1;2;3");

        });

    }

    @Override
    protected void runMain() {

    }
}
