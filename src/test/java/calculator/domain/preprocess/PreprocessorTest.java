package calculator.domain.preprocess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

}