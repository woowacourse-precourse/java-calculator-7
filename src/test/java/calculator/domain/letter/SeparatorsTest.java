package calculator.domain.letter;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SeparatorsTest {
    @Test
    void 추출한_커스텀_구분자를_구분자에_등록() {
        //given
        String extraction = ";";
        Separators separators = new Separators();

        //when
        separators.addSeparator(extraction);

        //then
        assertThat(separators.contains(extraction)).isEqualTo(true);
    }

    @Test
    void 기본적인_구분자가_등록되어_있는지() {
        //given
        String initialSeparator1 = ":";
        String initialSeparator2 = ",";

        //when
        Separators separators = new Separators();

        //then
        assertThat(separators.contains(initialSeparator1)).isEqualTo(true);
        assertThat(separators.contains(initialSeparator2)).isEqualTo(true);
    }

}