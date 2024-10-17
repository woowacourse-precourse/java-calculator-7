package study.jdk_feature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ToJdk21Test {

    @Test
    @DisplayName("JDK 21 switch 패턴 매칭: 분기문 없이 캐스팅 가능")
    void patternMatchingSwitch() {
        Animal dog = new Dog();
        Animal cat = new Cat();

        assertThat(cry(dog)).isEqualTo("멍멍");
        assertThat(cry(cat)).isEqualTo("야옹");
    }

    @Test
    @DisplayName("JDK 21 순차 컬렉션: 정렬(순차적 접근)을 제공하는 컬렉션의 문제점 보완")
    void sequencedCollection() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));

        numbers.addFirst(0);
        numbers.addLast(5);

        assertThat(numbers.getFirst()).isEqualTo(0);
        assertThat(numbers.getLast()).isEqualTo(5);

        numbers.removeFirst();
        numbers.removeLast();

        assertThat(numbers).containsExactly(1, 2, 3, 4);
        assertThat(numbers.reversed()).containsExactly(4, 3, 2, 1);
    }

    @Test
    @DisplayName("JDK 21 순차 컬렉션 참조 상황: 원본 데이터에 영향")
    void sequencedCollection_참조() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> reversed = numbers.reversed();

        numbers.addFirst(0);
        reversed.addFirst(5);

        assertThat(numbers).containsExactly(0, 1, 2, 3, 4, 5);
        assertThat(reversed).containsExactly(5, 4, 3, 2, 1, 0);
    }

    private String cry(Animal animal) {
        return switch (animal) {
            case Dog dog -> dog.cry();
            case Cat cat -> cat.cry();
            default -> "";
        };
    }

}
