package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ExtractorTest {

    @Test
    void 값을_입력하지_않은_경우() {
        //given
        String input = "";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(0).isEqualTo(result);
    }

    @Test
    void 숫자와_구분자_사이에_공백이_있는_경우() {
        //given
        String input = "6; 4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 기본구분자_사이에_숫자를_입력하지_않은_경우_1() {
        //given
        String input = ":,:";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(0).isEqualTo(result);
    }

    @Test
    void 기본구분자_사이에_숫자를_입력하지_않은_경우_2() {
        //given
        String input = ":1,:0";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(1).isEqualTo(result);
    }

    @Test
    void 기본구분자와_숫자를_입력한_경우() {
        //given
        String input = "1:2,3:4";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(10).isEqualTo(result);
    }

    @Test
    void 기본구분자에_해당되지_않는_문자를_입력한_경우_1() {
        //given
        String input = "6;4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 기본구분자에_해당되지_않는_문자를_입력한_경우_2() {
        //given
        String input = "a:b:c";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 기본구분자와_음수를_입력한_경우() {
        //given
        String input = "-1;4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }


    @Test
    void 커스텀구분자는_입력했지만_숫자를_입력하지_않은_경우() {
        //given
        String input = "//:\\n";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(0).isEqualTo(result);
    }

    @Test
    void 숫자는_입력했지만_커스텀구분자를_입력하지_않은_경우() {
        //given
        String input = "//\\n4";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(4).isEqualTo(result);
    }

    @Test
    void 커스텀구분자가_여러개_입력된_경우() {
        //given
        String input = "//;/\\n3/4";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 하나의 문자만 지정할 수 있습니다.");

    }

    @Test
    void 커스텀구분자를_구분하는_문자를_입력하지_않은_경우() {
        //given
        String input = "//:34";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 기본구분자와_커스텀구분자가_모두_존재할때() {
        //given
        String input = "//;\\n3:3;3";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(9).isEqualTo(result);
    }

    @Test
    void 기본구분자와_커스텀구분자가_모두_존재할때_기본구분자만_사용된_경우() {
        //given
        String input = "//;\\n3:3,3";
        Extractor extractor = new Extractor(input);
        Addition addition = new Addition(extractor.getNumbers());

        //when
        extractor.extractNumbers();
        int result = addition.addNumber();

        //then
        assertThat(9).isEqualTo(result);
    }

    @Test
    void 기본구분자와_커스텀구분자가_모두_존재할때_커스텀구분자를_잘못_입력한_경우() {
        //given
        String input = "//;\\n3;4&5";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }
}