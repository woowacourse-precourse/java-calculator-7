package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserInputStringTest {

    @Test
    void getInput_correct() {
        // when
        UserInput userInputString = new UserInput("test");

        // given
        String userInput = userInputString.getInput();

        // then
        assertThat(userInput).isEqualTo("test");
    }

    @Test
    void isInputEmpty_false() {
        // when
        UserInput userInput = new UserInput("");

        // given
        boolean inputString = userInput.isInputEmpty();

        // then
        assertThat(inputString).isTrue();
    }

    @Test
    void isInputEmpty_true() {
        // when
        UserInput userInput = new UserInput("test");

        // given
        boolean inputString = userInput.isInputEmpty();

        // then
        assertThat(inputString).isFalse();
    }
}
