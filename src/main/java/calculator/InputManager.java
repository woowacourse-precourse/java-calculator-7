package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    private final Validator validator;
    public InputManager(Validator validator){
        this.validator = validator;
    }

    public String getInput(){
        String input = readLine();
        validator.isValid(input);
        return input;
    }


}
