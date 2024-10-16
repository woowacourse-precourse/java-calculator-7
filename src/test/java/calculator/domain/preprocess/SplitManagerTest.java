package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitManagerTest {

    SplitManager splitManager = new SplitManager();

    @Test
    @DisplayName("extractNumbers 빈칸 제거까지 있는 기능 테스트")
    void extractNumbers_withblank() {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":", "<"));

        List<String> result = splitManager.extractNumbers(delimeterList, "2,3:4<");
        List<String> expected = new ArrayList<>(Arrays.asList("2", "3", "4"));

        assertTrue(expected.containsAll(result));
    }

    @Test
    @DisplayName("extractNumbers 빈칸 발생 없는 기능 테스트")
    void extractNumbers_withoutblank() {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":", "<"));

        List<String> result = splitManager.extractNumbers(delimeterList, "2,3:4<5");
        List<String> expected = new ArrayList<>(Arrays.asList("2", "3", "4", "5"));

        assertTrue(expected.containsAll(result));
    }
}