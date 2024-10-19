package calculator.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.utils.ParsingUtils.parsingUserInput;
import static org.junit.jupiter.api.Assertions.*;

class ParsingUtilsTest {

    @Test
    @DisplayName("사용자 입력 두 부분 나누기 - 커스텀 x")
    void 사용자_입력_분리_커스텀_X_테스트(){
        String userInput = "1,2:3";

        List<String> parsedUserInput = parsingUserInput(userInput);

        Assertions.assertThat(parsedUserInput.size()).isEqualTo(1);
        Assertions.assertThat(parsedUserInput.getFirst()).isEqualTo(userInput);
    }

    @Test
    @DisplayName("사용자 입력 두 부분 나누기 - 커스텀 O")
    void 사용자_입력_분리_커스텀_O_테스트(){
        String userInput = "//[]\n1,2:3";

        List<String> parsedUserInput = parsingUserInput(userInput);

        Assertions.assertThat(parsedUserInput.size()).isEqualTo(2);
        Assertions.assertThat(parsedUserInput.getFirst()).isEqualTo("[]");
        Assertions.assertThat(parsedUserInput.getLast()).isEqualTo("1,2:3");
    }

}