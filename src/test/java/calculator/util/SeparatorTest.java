package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {
    @Test
    @DisplayName("문자열의 구분자가 ','로만 들어왔을 때 구분할 수 있다.")
    public void separateDefaultRestTest() {
        // GIVEN
        String input = "1,2,3,4,5,";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("문자열의 구분자가 ':'로만 들어왔을 때 구분할 수 있다.")
    public void separateDefaultColonTest() {
        // GIVEN
        String input = ":1:2:3:4:5:";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("문자열의 구분자가 ':'와 `,`로 들어왔을 때 구분할 수 있다.")
    public void separateDefaultTest() {
        // GIVEN
        String input = ":1,2:3,4:5,";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("커스텀 구분자를 구분할 수 있다.")
    public void separateCustomTest() {
        // GIVEN
        String input = "//a\\na1a2a3a4a5";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자가 섞인 문자열에서 숫자를 구분한다.")
    public void separateAllTest() {
        // GIVEN
        String input = "//a\\na1,2:3a4,5";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("커스텀 구분자의 앞부분과 뒷부분이 매칭되지 않는 상황에서 숫자로 파싱되지 않은 결과를 반환한다.")
    public void invalidCustomTest() {
        // GIVEN
        String input = "\\n1//213";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).contains(input);
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자일 때 정확한 값을 구분한다.")
    public void separateNumberCustomTest() {
        // GIVEN
        String input = "//12\\n121122123124125";

        // WHEN
        List<String> stringNumbers = Separator.separate(input);

        // THEN
        assertThat(stringNumbers).hasSize(5);
        assertThat(stringNumbers).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("String으로 된 숫자를 파싱한다.")
    public void parseNumberTest() {
        // GIVEN
        List<String> stringNumbers = List.of("1", "2", "3", "4", "5");

        // WHEN
        List<Long> numbers = Separator.parseEachNumber(stringNumbers);

        // THEN
        assertThat(numbers).hasSize(5);
        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L, 5L);
    }

    @Test
    @DisplayName("파싱된 문자열에 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.")
    public void notNumberTest() {
        // GIVEN
        List<String> stringNumbers = List.of("1", "2,", "a", "4", "5");

        // WHEN - THEN
        assertThrows(IllegalArgumentException.class, () -> Separator.parseEachNumber(stringNumbers));
    }

    @Test
    @DisplayName("양수가 아닐경우 `IllegalArgumentException`을 발생시킨다.")
    public void nonPositiveNumberTest() {
        // GIVEN
        List<String> stringNumbers1 = List.of("1", "2,", "-3", "4", "5");
        List<String> stringNumbers2 = List.of("1", "2,", "0", "4", "5");

        // WHEN - THEN
        assertThrows(IllegalArgumentException.class, () -> Separator.parseEachNumber(stringNumbers1));
        assertThrows(IllegalArgumentException.class, () -> Separator.parseEachNumber(stringNumbers2));
    }

    @Test
    @DisplayName("`Long` 범위를 넘어선 경우, `IllegalArgumentException`을 발생시킨다.")
    public void overflowTest() {
        // GIVEN
        List<String> stringNumbers = List.of("1", "2", "3", "4", "555555555555555555555555555555555555555555555555");

        // WHEN - THEN
        assertThrows(IllegalArgumentException.class, () -> Separator.parseEachNumber(stringNumbers));
    }
}
