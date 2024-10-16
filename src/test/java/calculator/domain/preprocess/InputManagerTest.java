package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {

    InputManager inputManager = new InputManager();

    @Test
    @DisplayName("isInteger 기능 테스트")
    void isInteger_test() {
        assertTrue(inputManager.isInteger("3"));
        assertFalse(inputManager.isInteger("z"));
    }


    @Test
    @DisplayName("findNoneDelimeterString 기능 테스트")
    void findNoneDelimeterString_o(){
        assertDoesNotThrow(()->
                inputManager.findNoneDelimeterString(Arrays.asList(",",":"),"1,2,3,4:5:6:7"));
    }

    @Test
    @DisplayName("findNoneDelimeterString 예외 테스트")
    void findNoneDelimeterString_x(){
        IllegalArgumentException e= assertThrows(IllegalArgumentException.class,()->
                inputManager.findNoneDelimeterString(Arrays.asList(",",":"),"1,2>3,4:5:6:7"));

        assertEquals(e.getMessage(),"구분자 이외의 문자가 있습니다.");
    }
}