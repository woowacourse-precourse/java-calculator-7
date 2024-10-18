package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorsTest {
    @Test
    @DisplayName("구분자중 하나의 값을 인식하는 정규식을 반환하는지 확인")
    void toRegexAllowOneOfSeparator() {
        Separator commaSeparator = new Separator(",");
        Separator colonSeparator = new Separator(":");
        Separator customSeparator = new Separator(";");
        Separators separators = new Separators(Set.of(commaSeparator, colonSeparator, customSeparator));
        String actualRegex = separators.toRegexAllowOneOfSeparator();

        List<String> expectedRegexes = List.of(";|:|,", ";|,|:", ":|,|;", ":|;|,", ",|:|;", ",|;|:");

        assertThat(actualRegex).isIn(expectedRegexes);
    }
}