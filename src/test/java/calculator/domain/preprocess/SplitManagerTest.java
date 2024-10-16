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
    @DisplayName("discardBlanckSpace 기능 테스트")
    void discardBlankSpace_test(){
        List<String> result = splitManager.discardBlankSpace(new ArrayList<>(Arrays.asList("1","2","")));
        List<String> expected = Arrays.asList("1","2");

        assertTrue(expected.containsAll(result));
    }

}