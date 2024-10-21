package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @Test
    void 기본_구분자_문자열_분리_테스트() {
        StringSplitter splitter = new StringSplitter();
        String input = "1,2,3";
        String[] result = splitter.split(input, ",");
        assertThat(result).containsExactly("1", "2", "3");
    }
    
    @Test
    void 커스텀_구분자_문자열_분리_테스트() {
        InputHandler inputHandler = new InputHandler(); // 커스텀 구분자 처리 담당
        StringSplitter splitter = new StringSplitter();
        
        String input = "//;\\n1;2;3";
        
        // 커스텀 구분자 추출 및 처리
        String delimiters = inputHandler.getDelimiters(input); // ';' 추출
        String processedInput = inputHandler.getProcessedInput(input); // "1;2;3"만 남김
        
        // StringSplitter로 문자열 분리
        String[] result = splitter.split(processedInput, delimiters);
        
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자_빈_문자열_예외_테스트_1() {
        StringSplitter splitter = new StringSplitter();
        String input = ",,,";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 숫자가 포함되어 있지 않습니다.");
    }
    
    @Test
    void 기본_구분자_빈_문자열_예외_테스트_2() {
        StringSplitter splitter = new StringSplitter();
        String input = "1,,3";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }
    
    @Test
    void 기본_구분자_빈_문자열_예외_테스트_3() {
        StringSplitter splitter = new StringSplitter();
        String input = "1, ,3";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }
    
    @Test
    void 커스텀_구분자_빈_문자열_예외_테스트_1() {
        StringSplitter splitter = new StringSplitter();
        InputHandler inputHandler = new InputHandler();
        
        String input = "//;\\n;;;";
        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);

        assertThatThrownBy(() -> splitter.split(processedInput, delimiters))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 숫자가 포함되어 있지 않습니다.");
    }

    @Test
    void 커스텀_구분자_빈_문자열_예외_테스트_2() {
        StringSplitter splitter = new StringSplitter();
        InputHandler inputHandler = new InputHandler();
        
        String input = "//;\\n1;;3";
        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);

        assertThatThrownBy(() -> splitter.split(processedInput, delimiters))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }

    @Test
    void 커스텀_구분자_빈_문자열_예외_테스트_3() {
        StringSplitter splitter = new StringSplitter();
        InputHandler inputHandler = new InputHandler();
        
        String input = "//;\\n1; ;3";
        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);

        assertThatThrownBy(() -> splitter.split(processedInput, delimiters))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }

}
