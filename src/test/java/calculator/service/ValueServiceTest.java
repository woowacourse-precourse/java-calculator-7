package calculator.service;

import calculator.domain.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class ValueServiceTest {

    @DisplayName("커스텀 구분자가 있는 문자열에서 커스텀 구분자 표시를 제거한다.")
    @Test
    void removeMarking(){
        ValueService.saveUserInput("//;\\n1");
        ValueService.removeMarking();
        String originalInput = ValueService.getOriginalInput();

        assertThat(originalInput).isEqualTo("n1");
    }

    @DisplayName("사용자에게 입력받은 최초의 문자열을 구분자로 나눈다.")
    @Test
    void separateInputString(){
        ValueService.saveUserInput("//;\\n1");
        SeparatorService.makeUpSeparators();
        ValueService.separateInputString();
        String[] parts = Value.getSeparatedValue();
        String[] array = {"n1"};

        assertTrue(Arrays.equals(array,parts));
    }
}
