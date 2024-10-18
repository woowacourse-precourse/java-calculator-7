package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SeparatorExtractorTest {
    private final SeparatorExtractor extractor = new SeparatorExtractor(Constant.EXTRACT_REGEX_TEST);

    @Test
    public void 커스텀_구분자_추출() {
        //given
        List<String> customSeparator = new ArrayList<>();
        String input = "//;\n4,5:6;//--\n1;2--//^^^\n1;2--3";

        //when
        String stringAfterExtract = extractor.extractCustomSeparator(input, customSeparator);

        //then
        assertThat(customSeparator.size()).isEqualTo(3);
        assertThat(customSeparator).containsExactly(";", "--", "^^^");
        assertThat(stringAfterExtract).isEqualTo("4,5:6;1;2--1;2--3");
    }

}