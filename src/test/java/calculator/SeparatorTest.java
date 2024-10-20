package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class SeparatorTest {
    @Test
    void constructingTest() {
        Separator someSeparator = new Separator('x');
        Separator defaultSeparator1 = new Separator(',');
        Separator defaultSeparator2 = new Separator(null);

        List<Character> someDividers = someSeparator.getDividers();
        List<Character> defaultDividers1 = defaultSeparator1.getDividers();
        List<Character> defaultDividers2 = defaultSeparator2.getDividers();

        assertThat(someDividers).contains('x');
        assertThat(defaultDividers1).containsOnlyOnce(',');
        assertThat(defaultDividers2).containsExactlyInAnyOrder(',', ':');
    }

    @Test
    void basicSeparateTest() {
        Separator separator = new Separator('*');

        String normalCase = "123*456,789:123";
        String invalidCase = "-123*456,789:123";

        assertThat(separator.separate(normalCase))
                .containsExactly("123", "456", "789", "123");
        assertThatThrownBy(()-> separator
                .separate(invalidCase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberSeparatorTest() {
        Separator numberSeparator = new Separator('3');

        String testInput = "123456,789:123";

        assertThat(numberSeparator.separate(testInput))
                .containsExactly("12", "456", "789", "12");
    }

    @Test
    void separatorInInputTest() {
        Separator separator = new Separator(null);

        String input = "123:";

        assertThat(separator.separate(input))
                .containsExactly("123");
    }

    @Test
    void consecutiveSeparatorInputTest(){
        Separator separator = new Separator(null);

        String input = "1,:,::,:,:,:,:,:,::,:,:,:2";

        assertThat(separator.separate(input))
                .containsExactly("1", "2");
    }
}