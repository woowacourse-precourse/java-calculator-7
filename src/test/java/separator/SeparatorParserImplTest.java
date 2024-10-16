package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SeparatorParserImplTest {
    private static Separator separator = new SeparatorImpl();
    private static final SeparatorParser parser = new SeparatorParserImpl();

    @BeforeEach
    void setUp() {
        separator = new SeparatorImpl();
    }

    @Test
    @DisplayName("구분자를 통한 구분 확인")
    void 구분자_받아_파싱() {
        //given
        parser.setSeparator(separator);
        //when
        List<String> output = parser.split("1,2,3:4:5");
        List<String> expectedOutput = List.of("1", "2", "3", "4", "5");
        //then
        Assertions.assertThat(output).containsExactlyElementsOf(expectedOutput);
    }

    @Test
    @DisplayName("커스텀 구분자 받아서, 구분 확인")
    void 커스텀_구분자_받아_파싱() {
        //given
        separator.addSeparator("\n");
        separator.addSeparator("\\");
        separator.addSeparator("7");
        parser.setSeparator(separator);
        //when
        List<String> output = parser.split("1:2\n3,4\\576");
        List<String> expectedOutput = List.of("1", "2", "3", "4", "5", "6");
        //then
        Assertions.assertThat(output).containsExactlyElementsOf(expectedOutput);
    }

    @Test
    @DisplayName("구분자를 통한 구분 확인")
    void 커스텀_구분자_2글자_이상() {
        //given
        separator.addSeparator("---");
        separator.addSeparator("77");
        parser.setSeparator(separator);
        //when
        List<String> output = parser.split("1:2---4:5777");
        List<String> expectedOutput = List.of("1", "2", "4", "5", "7");
        //then
        Assertions.assertThat(output).containsExactlyElementsOf(expectedOutput);
    }
}
