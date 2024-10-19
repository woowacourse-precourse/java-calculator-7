package calculator.option;

import calculator.validator.Validator;

public class Custom implements Calculator{

    private String input;
    private String separator;
    private Validator validator;

    public Custom(String input){
        this.input = input;
        validator = new Validator(input);
        separator = String.valueOf(input.charAt(2));
    }
    //구분자로 분리, 배열에 숫자만 들어있는지 검증 후 배열을 반환한다.
    @Override
    public String[] validate() {
        String[] arr = input.substring(5).split(separator);
        if(validator.contentIsPosNum(arr)){
            return arr;
        }
        throw new IllegalArgumentException("입력이 잘못되었습니다.(Custom)");
    }
}
