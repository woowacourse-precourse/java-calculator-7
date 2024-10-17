package calculator.optionchecker;

import calculator.validator.Validator;

public class Optionchecker {

    private int option;
    private String input;
    private Validator validator;

    public Optionchecker(String input) {
        option = 0;
        this.input = input;
        validator = new Validator(input);
    }
    //공백과 문자열의 마지막 문자가 숫자인지 확인한 후, 기본구분자인지 커스텀구분자인지 확인한다.
    public void optioncheck(){
        if(validator.checkValid()){
            if(input.charAt(0) == '/' && input.charAt(1) == '/'&&input.charAt(3) == '\\' && input.charAt(4) == 'n'){
                option = 2;
            }
            else {
                option = 1;
            }
        }
    }

    public int getoption() {
        return option;
    }
}
