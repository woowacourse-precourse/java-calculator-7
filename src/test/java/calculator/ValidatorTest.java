package calculator;


import calculator.validators.Validators;
import org.junit.jupiter.api.BeforeEach;


public class ValidatorTest {

    private Validators validators;

    @BeforeEach
    void setUp() {
        validators = new Validators();
    }
}
