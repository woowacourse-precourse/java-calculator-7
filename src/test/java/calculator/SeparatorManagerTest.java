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
}