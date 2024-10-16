package calculator.delimiter.handler;

import calculator.delimiter.handler.NoDelimiterHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NoDelimiterHandlerTest {
    @Test
    @DisplayName("비어있는 문자열이 들어올 경우 0을 반환한다.")
    void calculate_sum_with_empty_string() {
        NoDelimiterHandler noDelimiterHandler = new NoDelimiterHandler();
        String str = "";

        List<String> stringList = noDelimiterHandler.split(str);

        assertThat(stringList.isEmpty()).isTrue();
    }
}