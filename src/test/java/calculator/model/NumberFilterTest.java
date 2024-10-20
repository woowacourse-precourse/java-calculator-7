package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberFilterTest {

    private NumberFilter numberFilter;

    @BeforeEach
    public void setUp() {
        numberFilter = new NumberFilter();
    }

    @Test
    @DisplayName("숫자 필터링 기능 테스트_기본 구분자 경우")
    public void filterNumberTest1() {
        // given
        String inputString1 = "1,2";
        String inputString2 = "1,2:3";
        String inputString3 = "13:27:3";
        String inputString4 = "139,20:3576";

        // when
        List<Long> numbers1 = numberFilter.filter(inputString1, "[:|,]");
        List<Long> numbers2 = numberFilter.filter(inputString2, "[:|,]");
        List<Long> numbers3 = numberFilter.filter(inputString3, "[:|,]");
        List<Long> numbers4 = numberFilter.filter(inputString4, "[:|,]");

        // then
        assertThat(numbers1).containsExactly(1L, 2L);
        assertThat(numbers2).containsExactly(1L, 2L, 3L);
        assertThat(numbers3).containsExactly(13L, 27L, 3L);
        assertThat(numbers4).containsExactly(139L, 20L, 3576L);
    }

    @Test
    @DisplayName("숫자 필터링 기능 테스트_커스텀 구분자 경우")
    public void filterNumberTest2() {
        // given
        String inputString1 = "1.2";
        String inputString2 = "1*2*3";
        String inputString3 = "13?27?3";
        String inputString4 = "139b20b3576";
        String inputString5 = "1<3<4";

        // when
        List<Long> numbers1 = numberFilter.filter(inputString1, ".");
        List<Long> numbers2 = numberFilter.filter(inputString2, "*");
        List<Long> numbers3 = numberFilter.filter(inputString3, "?");
        List<Long> numbers4 = numberFilter.filter(inputString4, "b");
        List<Long> numbers5 = numberFilter.filter(inputString5, "<");

        // then
        assertThat(numbers1).containsExactly(1L, 2L);
        assertThat(numbers2).containsExactly(1L, 2L, 3L);
        assertThat(numbers3).containsExactly(13L, 27L, 3L);
        assertThat(numbers4).containsExactly(139L, 20L, 3576L);
        assertThat(numbers5).containsExactly(1L, 3L, 4L);
    }
}
