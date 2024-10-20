package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomSeparatorSplitterTest {
    @Test
    void 커스텀_구분자를_추출() {
        //given
        String separator = ";";
        String letters = "//" + separator + "\\n";
        CustomSeparatorSplitter customSeparatorSplitter = new CustomSeparatorSplitter();

        //when
        String[] customSeparator = customSeparatorSplitter.extractCustomSeparatorFromLetters(letters);

        //then
        Assertions.assertThat(customSeparator[0]).isEqualTo(separator);
    }

    @Test
    void 커스텀_구분자가_문자열_중간에_나오는_경우_커스텀_구분자_추출() {
        //given
        String separator = ";";
        String letters = "3//;\\n1;2";
        CustomSeparatorSplitter customSeparatorSplitter = new CustomSeparatorSplitter();

        //when
        String[] customSeparator = customSeparatorSplitter.extractCustomSeparatorFromLetters(letters);

        //then
        Assertions.assertThat(customSeparator[0]).isEqualTo(separator);
    }

    @Test
    void 커스텀_구분자가_두_번_나올_때_커스텀_구분자_추출() {
        //given
        String[] separator = {";", "@"};
        String letters = "//;\\n1//@\\n2@3";
        CustomSeparatorSplitter customSeparatorSplitter = new CustomSeparatorSplitter();

        //when
        String[] customSeparator = customSeparatorSplitter.extractCustomSeparatorFromLetters(letters);

        //then
        Assertions.assertThat(customSeparator[0]).isEqualTo(separator[0]);
        Assertions.assertThat(customSeparator[1]).isEqualTo(separator[1]);
    }

    @Test
    void 커스텀_구분자_길이가_2일_경우() {
        //given
        String separator = ";;";
        String letters = "//;;\\n1;;2";
        CustomSeparatorSplitter customSeparatorSplitter = new CustomSeparatorSplitter();

        //when
        String[] customSeparator = customSeparatorSplitter.extractCustomSeparatorFromLetters(letters);

        //then
        Assertions.assertThat(customSeparator[0]).isEqualTo(separator);
    }


}