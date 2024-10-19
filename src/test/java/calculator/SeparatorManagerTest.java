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
    void separatingTest() {
        SeparatorManager separatorManager = new SeparatorManager('*');

        String normalCaseString = "123*456,789;123";
        String invalidCaseString = "-123*456,789;123";

        assertThat(separatorManager.getSeparatedStringNumber(normalCaseString))
                .contains("123", "456", "789", "123");
        assertThatThrownBy(()-> separatorManager
                .getSeparatedStringNumber(invalidCaseString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void separatingWithNumberSeparatorTest() {
        SeparatorManager numberSeparatorManager = new SeparatorManager('3');

        String testString = "123456,789;123";

        assertThat(numberSeparatorManager.getSeparatedStringNumber(testString))
                .contains("12", "456", "789", "12");
    }

    @Test
    void separatingConsecutiveSeparatorsStringTest(){
        SeparatorManager separatorManager = new SeparatorManager(null);

        String testString = "1,;,;;,;,;,;,;,;,;;,;,;,;2";

        assertThat(separatorManager.getSeparatedStringNumber(testString))
                .containsExactly("1", "2");

    }
}