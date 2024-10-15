package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputOutputTest extends NsTest {

    @Test
    @DisplayName("입력을 받아 그대로 출력")
    void inputOutputTest() {
        assertSimpleTest(() -> {
            run("새로운 입력을 받았습니다.");
            // 그대로 출력
            assertThat(output()).isEqualTo("새로운 입력을 받았습니다.");
        });
    }

    static class customApplication {
        public static void main(String[] args) {
            String input = Console.readLine();
            System.out.println(input);
        }
    }

    @Override
    protected void runMain() {
        customApplication.main(new String[]{});
    }
}
