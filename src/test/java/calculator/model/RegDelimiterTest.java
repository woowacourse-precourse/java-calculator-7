package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegDelimiterTest {

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자가 등록된 구분자 목록에 저장된다.")
    @Test
    void registerCustomDeli_WhenInputCustomDelimiter_1() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%$\\n1%2,3";

        regDelimiter.registerCustomDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(5);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%$");
    }

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자가 등록된 구분자 목록에 저장된다.")
    @Test
    void registerCustomDeli_WhenInputCustomDelimiter_2() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%\\n1%2,3";

        regDelimiter.registerCustomDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(4);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%");
    }
}
