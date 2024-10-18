package calculator;

public class AppConfig {
    public static String CUSTOM_DELIMITER_PATTERN = "^//.\\\\n.*";
    public static final char[]DEFAULT_DELIMITERS = {',', ':'};
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
