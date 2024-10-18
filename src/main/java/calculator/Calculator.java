package calculator;

import java.util.List;

public class Calculator {
    private InputManager inputManager;
    private Parser parser;
    private MathUtils mathUtils;

    public Calculator(InputManager inputManager, Parser parser, MathUtils mathUtils){
        this.inputManager = inputManager;
        this.parser = parser;
        this.mathUtils = mathUtils;
    }

    public void calculate(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = inputManager.getInput();
        List<Integer>numbers = parser.parseNumber(input);
        int result = mathUtils.add(numbers);

        System.out.println("결과 : " + result);


    }


}
