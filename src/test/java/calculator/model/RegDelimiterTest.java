package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RegDelimiterTest {

    @Test
    void 커스텀_구분자가_있으면_true_반환() {
        //Given
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString1 = "//%\n1%2";
        String testString2 = "//";

        //When
        boolean includesCustomDeli1 = regDelimiter.includesCustomDelimiter(testString1);
        boolean includesCustomDeli2 = regDelimiter.includesCustomDelimiter(testString2);

        //Then
        assertThat(includesCustomDeli1).isTrue();
        assertThat(includesCustomDeli2).isTrue();
    }

    @Test
    void 커스텀_구분자가_없으면_false_반환() {
        //Given
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "1,2";

        boolean includesCustomDeli = regDelimiter.includesCustomDelimiter(testString);

        assertThat(includesCustomDeli).isFalse();
    }
}
