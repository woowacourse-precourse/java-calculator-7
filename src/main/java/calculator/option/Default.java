package calculator.option;

import calculator.validator.Validator;

public class Default implements Calculator {

    private String input;
    private Validator validator;

    public Default(String input){
        this.input = input;
        validator = new Validator(input);
    }
    //구분자로 분리, 배열에 숫자만 들어있는지 검증 후 배열을 반환한다.
    @Override
    public String[] validate() {
        String[] arr = input.split("[,:]");
        if(validator.contentIsPosNum(arr)){
            return arr;
        }
        throw new IllegalArgumentException("입력이 잘못되었습니다.(Default)");
    }
}
