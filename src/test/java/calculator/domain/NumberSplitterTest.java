package calculator.domain;


import calculator.domain.separator.Separators;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberSplitterTest {
    @Test
    void 숫자_추출() {
        //given
        String letters = "1,2";
        Separators separators = new Separators();
        NumberSplitter numberSplitter = new NumberSplitter();

        //when
        String[] numbers = numberSplitter.getNumbersFromLetters(letters, separators);

        //then
        Assertions.assertThat(numbers[0]).isEqualTo("1");
        Assertions.assertThat(numbers[1]).isEqualTo("2");
    }


    @Test
    void 두자리_숫자_추출() {
        //given
        String letters = "11,22";
        Separators separators = new Separators();
        NumberSplitter numberSplitter = new NumberSplitter();

        //when
        String[] numbers = numberSplitter.getNumbersFromLetters(letters, separators);

        //then
        Assertions.assertThat(numbers[0]).isEqualTo("11");
        Assertions.assertThat(numbers[1]).isEqualTo("22");
    }

}