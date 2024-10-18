package calculator;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    @Test
    void shouldSplitStringWithoutCustomSeparator() {
        SeparatorManager sepManager = new SeparatorManager();
        StringSplitter splitter = new StringSplitter(sepManager);

        // 기본 구분자만 있는 문자열
        String input = "1,2:3";
        List<String> separators = sepManager.getSeparators(); // 기본 구분자 리스트 (쉼표, 콜론)

        // split 메서드 실행
        List<String> result = splitter.split(input, separators);

        // 결과 확인
        assertEquals(3, result.size(), "입력이 세 부분으로 분리되어야 합니다.");
        assertEquals("1", result.get(0), "첫 번째 부분은 '1'이어야 합니다.");
        assertEquals("2", result.get(1), "두 번째 부분은 '2'이어야 합니다.");
        assertEquals("3", result.get(2), "세 번째 부분은 '3'이어야 합니다.");
    }

    @Test
    void shouldSplitStringWithCustomSeparator() {
        String input = "//;\\n1;2,3";
        SeparatorManager sepManager = new SeparatorManager();
        String processedInput = sepManager.addCustomSeparatorAndTrim(input); // 커스텀 구분자 세미콜론 추가
        StringSplitter splitter = new StringSplitter(sepManager);

        List<String> separators = sepManager.getSeparators(); // 기본 + 커스텀 구분자

        // split 메서드 실행
        List<String> result = splitter.split(processedInput, separators);

        // 결과 확인
        assertEquals(3, result.size(), "입력이 세 부분으로 분리되어야 합니다.");
        assertEquals("1", result.get(0), "첫 번째 부분은 '1'이어야 합니다.");
        assertEquals("2", result.get(1), "두 번째 부분은 '2'이어야 합니다.");
        assertEquals("3", result.get(2), "세 번째 부분은 '3'이어야 합니다.");
        assertEquals("1;2,3",processedInput, "커스텀 구분자가 있을 경우 문자열에서 제외해야 합니다.");
    }
}
