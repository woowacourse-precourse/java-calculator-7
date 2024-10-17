package calculator;

public class Calculator {
    private InputManager inputManager;
    private Parser parser;
    private Adder adder;

    public Calculator(InputManager inputManager, Parser parser, Adder adder){
        this.inputManager = inputManager;
        this.parser = parser;
        this.adder = adder;
    }

    public void calculate(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = inputManager.getInput();
        System.out.println("결과 : ");

    }


}
