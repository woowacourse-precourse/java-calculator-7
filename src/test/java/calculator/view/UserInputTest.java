package calculator.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class UserInputTest {
    @Test
    @DisplayName("정상 입력 테스트 - 콤마와 콜론을 사용한 경우")
    public void inputTest1() {
        UserInput userInput = new UserInput();
        String input = "1,2:3";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = userInput.input();

        Assertions.assertThat("1,2:3").isEqualTo(result);
    }

    @Test
    @DisplayName("정상 입력 테스트 - 빈 문자열 입력한 경우")
    public void inputTest2() {
        UserInput userInput = new UserInput();
        String input = " ";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = userInput.input();

        Assertions.assertThat("0").isEqualTo(result);
    }

    @Test
    @DisplayName("비정상 입력 테스트 - 문자 입력")
    public void inputTest3() {
        UserInput userInput = new UserInput();
        String input = "1,a:2";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> userInput.input()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상 입력 테스트 - 구분자 중복 입력")
    public void inputTest4() {
        UserInput userInput = new UserInput();
        String input = "1,,2,3";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> userInput.input()).isInstanceOf(IllegalArgumentException.class);
    }
}
