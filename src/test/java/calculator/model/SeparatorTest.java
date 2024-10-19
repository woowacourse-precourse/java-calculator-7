package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Separator 클래스의 테스트 클래스. getSeparators, addSeparator, removeSeparator 메서드를 순차적으로 테스트한다.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeparatorTest {
    /**
     * 기본 구분자인 ','와 ':'가 포함된 구분자 리스트를 반환하는지 확인한다.
     */
    @Test
    @Order(1)
    void getSeparators() {
        // given
        ArrayList<Character> similarSeparators = new ArrayList<>();
        similarSeparators.add(',');
        similarSeparators.add(':');

        // when, then
        assertThat(Separator.getSeparators()).isEqualTo(similarSeparators);
        similarSeparators.clear();
    }

    /**
     * 구분자가 리스트에 성공적으로 추가되는지 확인한다.
     */
    @Test
    @Order(2)
    void addSeparator() {
        // given
        ArrayList<Character> addSeparators = new ArrayList<>();
        addSeparators.add(';');
        addSeparators.add('!');
        addSeparators.add('@');
        addSeparators.add('#');
        addSeparators.add('$');

        // when
        for (Character separator : addSeparators) {
            Separator.addSeparator(separator);
        }

        // then
        for (Character separator : addSeparators) {
            assertThat(Separator.getSeparators()).contains(separator);
        }
    }

    /**
     * 구분자가 리스트에서 성공적으로 제거되는지 확인한다.
     */
    @Test
    @Order(3)
    void removeSeparator() {
        //given
        ArrayList<Character> removeSeparators = new ArrayList<>();
        removeSeparators.add(';');
        removeSeparators.add('!');
        removeSeparators.add('@');
        removeSeparators.add('#');
        removeSeparators.add('$');
        removeSeparators.add(',');
        removeSeparators.add(':');

        // when
        for (Character s : removeSeparators) {
            Separator.removeSeparator(s);
        }

        // then
        assertThat(Separator.getSeparators()).isEmpty();
    }
}
