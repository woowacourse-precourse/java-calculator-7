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
    public void 문자를_숫자로_변환() throws Exception {
        StringConverter stringConverter = new StringConverter();
        List<Integer> numList = stringConverter.convertToNumbers(new String[]{"1","2","3"});
        assertThat(numList).isEqualTo(Arrays.asList(1,2,3));
    }
}
