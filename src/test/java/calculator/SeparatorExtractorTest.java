package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorExtractorTest {
    @Test
    public void 커스텀_구분자_추출() {
        //given
        SeparatorExtractor extractor = new SeparatorExtractor();
        List<String> customSeparator = new ArrayList<>();
        String input = "//;\n4,5:6;//--\n1;2--//^^^\n1;2--";
        //when
        String stringAfterExtract = extractor.extractCustomSeparator(input, customSeparator);

        //then
        assertThat(customSeparator.size()).isEqualTo(3);
        assertThat(customSeparator).containsExactly(";", "--", "^^^");
        assertThat(stringAfterExtract).isEqualTo("4,5:6;1;2--1;2--");
    }

}