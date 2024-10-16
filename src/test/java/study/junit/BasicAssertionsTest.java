package study.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit AssertJ 기본 Assertions 메서드")
class BasicAssertionsTest {

    @Test
    @DisplayName("isEqualTo(): equals() 사용 동등성(논리적 지위, 값) 비교, 참조 타입 equals() 미구현 시 Object equals()")
    void isEqualTo() {
        var dog = new Dog("복덕");
        var cat = new Cat("나비");

        var dogClone = new Dog("복덕");
        var catClone = new Cat("나비");

        assertThat(dog).isEqualTo(dogClone);
        assertThat(cat).isNotEqualTo(catClone);
    }

    @Test
    @DisplayName("isSameAs(): == 사용한 동일성(물리적 지위) 비교, int(-128 ~ 127 메모리 캐시)값 비교 진행(최적화와 관련)")
    void isSameAs() {
        String hello = "hello";
        String helloClone = "hello";
        int cachedNum = -128;
        int cachedNumClone = -128;
        int nonCachedNum = 128;
        int nonCachedNumClone = 128;

        assertThat(hello).isSameAs(helloClone);
        assertThat(cachedNum).isSameAs(cachedNumClone);
        assertThat(nonCachedNum).isNotSameAs(nonCachedNumClone);
    }

    @Test
    @DisplayName("isEqualTo() vs isXxx(): 실패 시 isEqualTo()의 실패 이유 가시성이 좋음")
    void isEqualTo_isXxx() {
        boolean flag = true;

        assertThat(!flag).isEqualTo(false);
        assertThat(!flag).isFalse();
    }

    @Test
    @DisplayName("자주 사용하는 String 테스트 메서드")
    void stringTestMethods() {
        assertThat("Frodo ").startsWith("Fro")
                .endsWith("do ")
                .contains("F")
                .containsWhitespaces()
                .containsIgnoringCase("frodo ")
                .isNotBlank();
    }

    @Test
    @DisplayName("자주 사용하는 Collection Framework 테스트 메서드")
    void collectionFrameworkTestMethods() {
        var numbers = List.of(1, 2, 3, 4);

        assertThat(numbers).hasSize(4)
                .contains(1)
                .containsExactly(1, 2, 3, 4)
                .doesNotContain(5);
        assertThat(numbers).filteredOn(number -> number < 3)
                .containsExactly(1, 2);

    }

    private record Dog(String name) {}

    private static class Cat {

        private final String name;

        public Cat(final String name) {
            this.name = name;
        }

    }

}
