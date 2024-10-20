package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {
    private static RegDelimiter defaultRegDelimiter = new RegDelimiter();

    @DisplayName("입력된 구분자가 등록된 구분자면 CORRECT로 모드를 설정하고 누적된 구분자를 초기화한다..")
    @Test
    void true_IfRegisteredDelimiter() {
        String testString = ",";
        Delimiter delimiter = new Delimiter(defaultRegDelimiter);

        delimiter.updateDelimiterAndMode(testString);

        assertThat(delimiter.getDelimiter()).isEqualTo("");
        assertThat(delimiter.getMode()).isEqualTo(DelimiterMode.CORRECT);
    }

    @DisplayName("입력 중인 구분자가 등록되지 않은 구분자면 WRONG로 모드를 설정하고 패스한다.")
    @Test
    void false_IfUnregisteredDelimiter_WhenDoingInput() {
        String testString = "!";
        Delimiter delimiter = new Delimiter(defaultRegDelimiter);

        delimiter.updateDelimiterAndMode(testString);

        assertThat(delimiter.getDelimiter()).isEqualTo("!");
        assertThat(delimiter.getMode()).isEqualTo(DelimiterMode.WRONG);
    }

    @DisplayName("입력 완료된 구분자가 등록되지 않은 구분자면 예외를 발생시킨다.")
    @Test
    void fail_IfUnregisteredDelimiter_WhenInputDone() {
        String testString = "!";
        Delimiter delimiter = new Delimiter(defaultRegDelimiter);

        delimiter.updateDelimiterAndMode(testString);

        assertThatThrownBy(() -> delimiter.validateDelimiter())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
