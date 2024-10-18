package calculator.domain.mainprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainProcessorTest {
    private MainProcessor mainProcessor = new MainProcessor();

    @Test
    @DisplayName("calculate 기능 테스트")
    void calculate_test(){
        List<String> given = new ArrayList<>(Arrays.asList("1","2","3","4"));
        assertEquals(mainProcessor.calculate(given),10);
    }

}