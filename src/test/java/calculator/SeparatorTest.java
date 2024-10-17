package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

    @Test
    @DisplayName("생성된 Separator가 생성자를 통해 넘겨준 String을 반환하는지 확인")
    void testGetSeparatorString() {
        String expectedSeparatorString = "separator";
        Separator separator = new Separator(expectedSeparatorString);

        String actual = separator.getSeparatorString();

        assertThat(actual).isEqualTo(expectedSeparatorString);
    }

    @Test
    @DisplayName("동일한 문자열로 생성한 separator가 equals를 통해 같은 객체인지 판단 확인")
    void testEquals() {
        String sameString = "separator";
        Separator separator = new Separator(sameString);
        Separator anotherSeparator = new Separator(sameString);

        assertThat(separator).isEqualTo(anotherSeparator);
    }

    @Test
    @DisplayName("동일한 문자열로 생성한 separator의 hashcode가 같은지 확인")
    void testHashCode() {
        String sameString = "separator";
        Separator separator = new Separator(sameString);
        Separator anotherSeparator = new Separator(sameString);

        assertThat(separator).hasSameHashCodeAs(anotherSeparator);
    }
}