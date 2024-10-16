package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
class InputGuidelinesTest {
    @DisplayName("문자열 덧셈 계산기의 안내사항들이 출력된다.")
    @Test
    void printInputGuidelines(){
    //given
        List<String> stringList = List.of(",", ":","@");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
    //when
        inputGuidelines.printInputGuidelines();
    //then
    }

    @DisplayName("기본 구분자가 하나의 문장으로 출력된다.")
    @Test
    void joinWithDefaultSeparator(){
        //given
        List<String> stringList = List.of(",", ":","@");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
        //when
        String joinWithDefaultSeparator = inputGuidelines.getJoinWithDefaultSeparator();
        //then
        org.assertj.core.api.Assertions.assertThat(joinWithDefaultSeparator).isEqualTo("( , ),( : ),( @ )");
    }



}