package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputParseTest {

    @Test
    @DisplayName("커스텀 구분자가 입력 되었을 때 커스텀 구분자를 구분자 집합에 추가한다.")
    void 커스텀_구분자_추가_TEST(){
        String validUserInput = "//;\n1,2:3";

        UserInputParse userInputParse = new UserInputParse(validUserInput);

        Assertions.assertThat(userInputParse.getDelimiters().size()).isEqualTo(3);
    }
}