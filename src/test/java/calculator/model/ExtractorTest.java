package calculator.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


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
    public void ExtractorDto_저장하기(){
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
}
