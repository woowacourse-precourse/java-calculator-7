package calculator;

public class AppConfig {
    public InputManager inputManager(){
        return new InputManager(validator());
    }

    public Validator validator(){
        return new Validator();
    }

    public Parser parser(){
        return new Parser();
    }

    public Adder adder(){
        return new Adder();
    }
}
