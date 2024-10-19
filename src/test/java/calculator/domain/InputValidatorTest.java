package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("커스텀 구분자가 존재하는지 확인")
    void 커스텀_구분자_존재_확인() {
        // given
        String input = "//;\\n";

        // when
        boolean existCustomSeparator = InputValidator.isExistCustomSeparator(input);

        // then
        assertThat(existCustomSeparator).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자가 여러 개 존재한다면 리스트로 반환")
    void 커스텀_구분자_리스트_반환() {
        // given
        String input = "//;+.-\\n";

        // when
        List<String> customSeparator = InputValidator.getCustomSeparator(input);

        // then
        assertThat(customSeparator.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("문자열에서 커스텀 구분자 정보 제거")
    void 커스텀_구분자_정보_제거() {
        // given
        String input = "//;\\n1;2;3";
        String expected = "1;2;3";

        // when
        String removedString = InputValidator.removeSeparatorInfo(input);

        // then
        assertThat(removedString).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자 리스트를 1개의 문자열로 변환")
    void 구분자_문자열_변환() {
        // given
        String input = "//;+-\\n1;2;3";
        String expected = ";+-";

        // when
        List<String> customSeparator = InputValidator.getCustomSeparator(input);
        String convertedString = InputValidator.convertString(customSeparator);

        // then
        assertThat(convertedString).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자로 숫자 분리")
    void 구분자_숫자_분리() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String cleanInput = InputValidator.removeSeparatorInfo(input);
        List<String> customSeparator = InputValidator.getCustomSeparator(input);
        List<Integer> numbers = InputValidator.separate(cleanInput, customSeparator);

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }
}