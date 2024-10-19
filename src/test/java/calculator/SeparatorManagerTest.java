package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class SeparatorManagerTest {
    @Test
    void constructingTest() {
        SeparatorManager someSeparatorManager = new SeparatorManager('x');
        SeparatorManager defaultSeparatorManager1 = new SeparatorManager(',');
        SeparatorManager defaultSeparatorManager2 = new SeparatorManager(null);

        List<Character> someSeparatorList = someSeparatorManager.getSeparatorList();
        List<Character> defaultSeparatorList1 = defaultSeparatorManager1.getSeparatorList();
        List<Character> defaultSeparatorList2 = defaultSeparatorManager2.getSeparatorList();

        assertThat(someSeparatorList).contains('x');
        assertThat(defaultSeparatorList1).containsOnlyOnce(',');
        assertThat(defaultSeparatorList2).containsExactlyInAnyOrder(',', ';');
    }

    @Test
    void basicSeparatingTest() {
        SeparatorManager separatorManager = new SeparatorManager('*');

        String normalCase = "123*456,789;123";
        String invalidCase = "-123*456,789;123";

        assertThat(separatorManager.getSeparatedStringNumber(normalCase))
                .containsExactly("123", "456", "789", "123");
        assertThatThrownBy(()-> separatorManager
                .getSeparatedStringNumber(invalidCase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void separatingWithNumberSeparatorTest() {
        SeparatorManager numberSeparatorManager = new SeparatorManager('3');

        String testInput = "123456,789;123";

        assertThat(numberSeparatorManager.getSeparatedStringNumber(testInput))
                .containsExactly("12", "456", "789", "12");
    }

    @Test
    void separatingEndsWithSeparatorStringTest() {
        SeparatorManager separatorManager = new SeparatorManager(null);

        String endsWithSeparator = "123;";

        assertThat(separatorManager.getSeparatedStringNumber(endsWithSeparator))
                .containsExactly("123");
    }

    @Test
    void separatingConsecutiveSeparatorsStringTest(){
        SeparatorManager separatorManager = new SeparatorManager(null);

        String consecutiveSeparators = "1,;,;;,;,;,;,;,;,;;,;,;,;2";

        assertThat(separatorManager.getSeparatedStringNumber(consecutiveSeparators))
                .containsExactly("1", "2");

    }
}