package calculator.domain.preprocess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PreprocessorTest {

    private InputManager inputManager;
    private DelimeterProcessor delimeterProcessor;
    private SplitManager splitManager;
    private Preprocessor preprocessor;

    @BeforeEach
    void setUp(){
        preprocessor = new Preprocessor(
                new DelimeterProcessor(),
                new InputManager(),
                new SplitManager());
    }

    @Test
    @DisplayName("preprocessDelimeter 예외 발생 테스트")
    void preprocessDelimeter_test_o(){

        String given = "//3\n2,3,4";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            preprocessor.preprocessDelimeter(given);
        });

        assertEquals(e.getMessage(),"구분자로 숫자를 입력했습니다");
    }

    @Test
    @DisplayName("preprocessDelimeter 기능 테스트")
    void preprocessDelimeter_test_x(){

        String given = "//;\n2,3,4";
        assertEquals(preprocessor.preprocessDelimeter(given), Arrays.asList(",",":",";"));
    }

}