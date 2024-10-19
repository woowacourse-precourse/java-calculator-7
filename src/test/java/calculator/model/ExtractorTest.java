package calculator.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ExtractorTest {
    @Test
    public void 커스텀_구분자_지정하기(){
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        ExtractorDto extractorDto =new ExtractorDto();
        Delimiter delimiter = new Delimiter();
        String[] divideDelimiterAndNumber = {"//", "1;2;3"};

        //When
        extractorDto=extractor.saveCustomDelimiter(extractorDto,delimiter,divideDelimiterAndNumber);

        //Then
        softly.assertThat(extractorDto.getDelimiters().size()).isEqualTo(1);
        softly.assertThat(extractorDto.getDelimiters().get(0)).isEqualTo("//");
        softly.assertThat(extractorDto.getValues()).isEqualTo("1;2;3");
        softly.assertAll();
    }

    @Test
    public void 구분자와_숫자_구분하여_저장하기(){
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        String calculationValue1 = "//;\\n1;2;3";
        String calculationValue2 = "1:2,3";

        //When
        ExtractorDto extractorDto1 = extractor.saveExtractorDto(calculationValue1);
        ExtractorDto extractorDto2 = extractor.saveExtractorDto(calculationValue2);

        //Then
        softly.assertThat(extractorDto1.getDelimiters().size()).isEqualTo(1);
        softly.assertThat(extractorDto1.getDelimiters().get(0)).isEqualTo(";");
        softly.assertThat(extractorDto1.getValues()).isEqualTo("1;2;3");
        softly.assertThat(extractorDto2.getDelimiters()).containsExactly(",", ":");
        softly.assertThat(extractorDto2.getDelimiters().size()).isEqualTo(2);
        softly.assertThat(extractorDto2.getValues()).isEqualTo("1:2,3");
        softly.assertAll();
    }

    @Test
    public void 숫자_추출하기(){
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        String calculationValue1="//;\\n1;2;3";
        String calculationValue2 = "1:2,,3";

        //When
        Numbers numbers1 = extractor.extractValues(calculationValue1);
        Numbers numbers2 = extractor.extractValues(calculationValue2);
        List<Number> values1 = numbers1.getNumbersValue();
        List<Number> values2 = numbers2.getNumbersValue();

        //Then
        softly.assertThat(values1.size()).isEqualTo(3);
        softly.assertThat(values2.size()).isEqualTo(4);
        softly.assertThat(values2.get(2).getValue()).isEqualTo(0);
        softly.assertAll();
    }

    @Test
    public void 입력된_값이_0이_아닐_때_오류발생(){
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        String calculationValue1="//;\\na;2;3";
        String calculationValue2 = "1:?,,3";

        //When & Then
        softly.assertThatThrownBy(() -> extractor.extractValues(calculationValue1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값이 숫자가 아닙니다.");
        softly.assertThatThrownBy(() -> extractor.extractValues(calculationValue2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값이 숫자가 아닙니다.");
        softly.assertAll();
    }
}
