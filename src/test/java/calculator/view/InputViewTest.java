package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;

class InputViewTest {

    @Test
    @DisplayName("콘솔을 통해 입력을 받는다")
    void readInput() {
        //given
        String targetInput = "//;4\\n3;2;1";
        System.setIn(new ByteArrayInputStream(targetInput.getBytes()));

        //when
        String input = Console.readLine();

        //then
        Assertions.assertThat(input)
                .isEqualTo(targetInput);
    }
}