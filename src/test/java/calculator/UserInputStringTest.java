package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserInputStringTest {

    @Test
    void getInput_correct() {
        // when
        UserInputString userInputString = new UserInputString("test");

        // given
        String userInput = userInputString.getInput();

        // then
        assertThat(userInput).isEqualTo("test");
    }

    @Test
    void isInputEmpty_false() {
        // when
        UserInputString userInputString = new UserInputString("");

        // given
        boolean inputString = userInputString.isInputEmpty();

        // then
        assertThat(inputString).isTrue();
    }

    @Test
    void isInputEmpty_true() {
        // when
        UserInputString userInputString = new UserInputString("test");

        // given
        boolean inputString = userInputString.isInputEmpty();

        // then
        assertThat(inputString).isFalse();
    }
}