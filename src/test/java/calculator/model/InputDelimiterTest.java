package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputDelimiterTest {
    private static RegDelimiter defaultRegDelimiter = new RegDelimiter();

    @DisplayName("입력된 구분자가 등록된 구분자면 CORRECT로 모드를 설정하고 누적된 구분자를 초기화한다..")
    @Test
    void true_IfRegisteredDelimiter() {
        String testString = ",";
        InputDelimiter inputDelimiter = new InputDelimiter(defaultRegDelimiter);

        inputDelimiter.updateDelimiter(testString);

        Assertions.assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
        Assertions.assertThat(inputDelimiter.getMode()).isEqualTo(DelimiterMode.CORRECT);
    }

    @DisplayName("입력된 구분자가 등록되지 않은 구분자면 WRONG로 모드를 설정하고 패스한다.")
    @Test
    void false_IfUnregisteredDelimiter() {
        String testString = "!";
        InputDelimiter inputDelimiter = new InputDelimiter(defaultRegDelimiter);

        inputDelimiter.updateDelimiter(testString);

        Assertions.assertThat(inputDelimiter.getDelimiter()).isEqualTo("!");
        Assertions.assertThat(inputDelimiter.getMode()).isEqualTo(DelimiterMode.WRONG);
    }



}
