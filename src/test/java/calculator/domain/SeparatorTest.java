package calculator;

import calculator.domain.UserString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserStringTest {

    @DisplayName("커스텀 구분자가 있다면 true를 반환한다.")
    @Test
    void checkCustomSeparator(){
        boolean customSeparator = UserString.checkCustomSeparator("//;\\n1");
        assertThat(customSeparator).isEqualTo(true);
    }

    @DisplayName("커스텀 구분자를 알아낸다.")
    @Test
    void getCustomSeparator(){
        String customSeparator = UserString.getCustomSeparator("//;\\n1");
        assertThat(customSeparator).isEqualTo(";");
    }

}
