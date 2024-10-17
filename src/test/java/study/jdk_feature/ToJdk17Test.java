package study.jdk_feature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ToJdk17Test {

    @Test
    @DisplayName("JDK9 불변 컬렉션 생성 of(): 추가/삭제/변경 불가능, 재할당 가능")
    void of_ImmutableCollection() {
        List<Integer> immutableNumbers = List.of(1, 2, 3, 4);
        List<Integer> reallocationNumbers = List.of(0);

        reallocationNumbers = new ArrayList<>(immutableNumbers);

        assertThatThrownBy(() -> immutableNumbers.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(immutableNumbers::removeFirst)
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> immutableNumbers.set(0, 0))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(reallocationNumbers).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("불변 컬렉션 생성 Collections.unmodifiableXxx: 원본에 영향을 받음")
    void unmodifiableList_ImmutableCollection() {
        // "완전한 불변"이라는 목적을 달성할 수 없음
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> immutableNumbers = Collections.unmodifiableList(numbers);

        numbers.add(5);

        assertThat(immutableNumbers).containsExactly(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> immutableNumbers.add(6))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @EmptySource
    @ValueSource(strings = {" ", "   "})
    @ParameterizedTest(name = "\"{0}\".isBlank true")
    @DisplayName("JDK11 String.isBlank(): empty() + 공백으로 이루어진 문자 true 반환")
    void string_isBlank(String input) {
        assertThat(input.isBlank()).isTrue();
    }

    @Test
    @DisplayName("JDK11 String.lines(): 개행문자(\\n, \\r, \\r\\n) 기준으로 여러 줄의 문자열을 Stream 반환")
    void string_lines() {
        String input = "//;\n1;2;3";

        List<String> lines = input.lines()
                .toList();

        assertThat(lines).containsExactly("//;", "1;2;3");
    }

    @Test
    @DisplayName("JDK16 instanceof 패턴 매칭: 명시적 타입 캐스팅 없이 참조변수 사용 가능")
    void patternMatchingInstanceof() {
        Animal dog = new Dog();
        Animal cat = new Cat();

        assertThat(cry(dog)).isEqualTo("멍멍");
        assertThat(cry(cat)).isEqualTo("야옹");
    }

    @Test
    @DisplayName("JDK16 Record: 불변 객체를 간단하게 정의")
    void record_immutableObject() {
        Member member = new Member("kim", 20);

        assertThat(member.name()).isEqualTo("kim");
        assertThat(member.age()).isEqualTo(20);
        assertThat(member).isEqualTo(new Member("kim", 20));
    }

    private String cry(Animal animal) {
        if (animal instanceof Dog dog) {
            return dog.cry();
        }
        if (animal instanceof Cat cat) {
            return cat.cry();
        }
        return "";
    }

    private record Member(String name, int age) {}

}
