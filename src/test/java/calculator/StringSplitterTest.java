package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {
    @DisplayName("쉼표 또는 콜론으로 구분자 분리")
    @Test
    void 기본구분자_분리(){
        StringSplitter splitter = new StringSplitter();
        String result[] = splitter.split("1,2:3");
        assertThat(result).containsExactly("1","2","3");
    }
}
