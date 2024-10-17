package calculator;

public class AppConfig {
    public InputManager inputManager(){
        return new InputManager();
    }

    public Parser parser(){
        return new Parser();
    }

    public Adder adder(){
        return new Adder();
    }
}
