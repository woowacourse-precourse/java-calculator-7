package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "1,2";

        boolean includesCustomDeli = regDelimiter.includesCustomDelimiter(testString);

        assertThat(includesCustomDeli).isFalse();
    }

    @Test
    void 커스텀_구분자_입력() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%%%";

        String customDeli = regDelimiter.findCustomDelimiter(testString);

        assertThat(customDeli).isEqualTo("%%%");
    }

    @Test
    void 잘못된_커스텀_구분자_입력_시_예외_발생() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString1 = "//%//";
        String testString2 = "//-";

        assertThatThrownBy(() -> regDelimiter.findCustomDelimiter(testString1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> regDelimiter.findCustomDelimiter(testString2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
