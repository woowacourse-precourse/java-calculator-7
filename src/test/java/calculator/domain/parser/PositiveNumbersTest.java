package calculator.domain.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersTest {
    private final List<PositiveNumberTest> numbers;

    public PositiveNumbersTest(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(PositiveNumberTest::new)
                .toList();
    }


    public int sum() {
        return numbers.stream()
                .mapToInt(PositiveNumberTest::getValue)
                .sum();
    }

    public List<Integer> getValues() {
        return numbers.stream()
                .map(PositiveNumberTest::getValue)
                .collect(Collectors.toList());
    }
}

class PositiveNumbersMethodTest {
    @Test
    @DisplayName("양수 리스트로 객체 생성 성공")
    void constructor_ok_1() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThatCode(() -> new PositiveNumbersTest(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("음수 포함 리스트로 객체 생성 실패 - IllegalArgumentException 발생")
    void constructor_fail_1() {
        List<Integer> numbers = List.of(-1, 2, 3);
        assertThatThrownBy(() -> new PositiveNumbersTest(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PositiveNumberExceptionMessageTest.NO_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("빈 리스트로 객체 생성 성공")
    void constructor_ok_2() {
        List<Integer> numbers = List.of();
        assertThatCode(() -> new PositiveNumbersTest(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("null 리스트로 객체 생성 실패")
    void constructor_fail_2() {
        assertThatThrownBy(() -> new PositiveNumbersTest(null))
                .isInstanceOf(NullPointerException.class);
    }


    @Test
    @DisplayName("총합 반환 성공 테스트")
    void sum_ok() {
        PositiveNumbersTest positiveNumbersTest = new PositiveNumbersTest(List.of(1, 2, 3));
        int sum = positiveNumbersTest.sum();
        Assertions.assertEquals(sum, 6);
    }

    @Test
    @DisplayName("값 반환 성공 테스트")
    void getValues_ok() {
        PositiveNumbersTest positiveNumbersTest = new PositiveNumbersTest(List.of(1, 2, 3));
        Assertions.assertDoesNotThrow(() -> positiveNumbersTest.getValues());
        Assertions.assertEquals(positiveNumbersTest.getValues().get(0), 1);
        Assertions.assertEquals(positiveNumbersTest.getValues().get(1), 2);
        Assertions.assertEquals(positiveNumbersTest.getValues().get(2), 3);
        Assertions.assertEquals(positiveNumbersTest.getValues().size(), 3);

    }


}