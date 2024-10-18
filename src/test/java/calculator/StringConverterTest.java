package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {
    @DisplayName("문자를 숫자로 변환")
    @Test
    void 문자를_숫자로_변환() {
        StringConverter stringConverter = new StringConverter();
        List<Integer> numList = stringConverter.convertToNumbers(new String[]{"1", "2", "3"});
        assertThat(numList).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("양수가 아닌 경우 에러(음수인 경우)")
    @Test
    void 양수가_아닌경우_에러1() {
        StringConverter stringConverter = new StringConverter();
        assertThatThrownBy(() -> stringConverter.convertToNumbers(new String[]{"-11", "2", "3"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양수가 아닌 경우 에러(숫자가 아닌경우)")
    @Test
    void 양수가_아닌경우_에러2() {
        StringConverter stringConverter = new StringConverter();
        assertThatThrownBy(() -> stringConverter.convertToNumbers(new String[]{"a", "2", "3"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
