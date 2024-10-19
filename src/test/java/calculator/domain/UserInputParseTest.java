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
    @ValueSource(strings = {"//\n1,2,3", "//[]\n1,2,3", "//3\n1,2,3"})
    @DisplayName("커스텀 구분자는 1자리 문자이다.")
    void 커스텀_구분자_1자리_문자_TEST(final String userInput){
        Assertions.assertThatThrownBy(() -> new UserInputParse(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 문자열은 기본 구분자와 커스텀 구분자로 파싱이 가능하다.")
    void 숫자_문자열_파싱_기능_TEST(){
        String userInput = "//;\n1.1,2:3;4";

        UserInputParse userInputParse = new UserInputParse(userInput);

        Assertions.assertThat(userInputParse.getNumbers().size()).isEqualTo(4);
        Assertions.assertThat(userInputParse.getNumbers().contains(1.1)).isTrue();
    }

    @Test
    @DisplayName("숫자 문자열은 숫자와 구분자로만 이루어져 있어야 한다.")
    void 잘못된_문자열_구성_TEST(){
        String invalidUserInput = "//;\n1.1,2:3;4,invalid";

        Assertions.assertThatThrownBy(() -> new UserInputParse(invalidUserInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}