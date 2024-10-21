package calculator.separator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparatorServiceTest {

    private SeparatorService separatorService;

    @BeforeEach
    void setUp() {
        separatorService = new SeparatorServiceImpl();
    }

    @Test
    void 기본_구분자로_문자열_분리() {
        // given
        String input = "1,2:3";
        String expectedSeparator = ",|:";

        // when
        String separator = separatorService.getSeparator(input);
        String[] result = separatorService.splitBySeparator(input, separator);

        // then
        assertThat(separator).isEqualTo(expectedSeparator);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자로_문자열_분리() {
        // given
        String input = "//;\\n1;2;3";
        String expectedSeparator = ",|:|;";

        // when
        String separator = separatorService.getSeparator(input);
        String processedInput = input.substring(5);  // 커스텀 구분자 부분 제거
        String[] result = separatorService.splitBySeparator(processedInput, separator);

        // then
        assertThat(separator).isEqualTo(expectedSeparator);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_메타문자로_분리() {
        // given
        String input = "//*\\n1*2*3";
        String expectedSeparator = ",|:|\\*";

        // when
        String separator = separatorService.getSeparator(input);
        String processedInput = input.substring(5);  // 커스텀 구분자 부분 제거
        String[] result = separatorService.splitBySeparator(processedInput, separator);

        // then
        assertThat(separator).isEqualTo(expectedSeparator);
        assertThat(result).containsExactly("1", "2", "3");
    }
}
