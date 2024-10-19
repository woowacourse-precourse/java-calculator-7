package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class UserInputParseTest {

    @Test
    @DisplayName("커스텀 구분자가 입력 되었을 때 커스텀 구분자를 구분자 집합에 추가한다.")
    void 커스텀_구분자_추가_TEST(){
        String validUserInput = "//;\n1,2:3";

        UserInputParse userInputParse = new UserInputParse(validUserInput);

        Assertions.assertThat(userInputParse.getDelimiters().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\n1,2,3", "//[]\n1,2,3"})
    @DisplayName("커스텀 구분자는 1자리 문자이다.")
    void 커스텀_구분자_1자리_문자_TEST(final String userInput){
        Assertions.assertThatThrownBy(() -> new UserInputParse(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}