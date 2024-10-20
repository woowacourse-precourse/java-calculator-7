package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    void 커스텀_구분자를_판단할_수_있다() {
        //given
        Converter converter = new Converter();
        String words = "//;\\n1;2;3";

        //when
        String customerDelimiter = converter.findCustomerDelimiter(words);

        //then
        assertThat(customerDelimiter).isEqualTo("1;2;3");
    }

    @Test
    void 구분자를_찾아_나눌_수_있다() {
        //given
        String str = "//;\\n1;2;3";
        Converter converter = new Converter();

        //when
        List<String> words = converter.separateWords(str);

        //then
        assertThat(words.get(0)).isEqualTo("1");
        assertThat(words.get(1)).isEqualTo("2");
        assertThat(words.get(2)).isEqualTo("3");
    }

    @Test
    void 빈_문자열은_0으로_간주한다() {
        //given
        String str = "";
        Converter converter = new Converter();

        //when
        List<Number> numbers = converter.convertWordsToString(str);

        //then
        assertThat(numbers.get(0)).isEqualTo(new Number(0));
    }

    @Test
    void 문자열에서_옳바른_숫자를_가져온다1() {
        //given
        String str = "1,2";
        Converter converter = new Converter();

        //when
        List<Number> numbers = converter.convertWordsToString(str);

        //then
        assertThat(numbers.get(0)).isEqualTo(new Number(1));
        assertThat(numbers.get(1)).isEqualTo(new Number(2));
    }
}
